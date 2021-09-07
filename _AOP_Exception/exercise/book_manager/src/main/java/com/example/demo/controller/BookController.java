package com.example.demo.controller;

import com.example.demo.model.entity.Book;
import com.example.demo.model.entity.Code;
import com.example.demo.model.service.BookService;

import com.example.demo.model.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CodeService codeService;

    @RequestMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 2, direction = Sort.Direction.ASC) Pageable pageable) {
        return new ModelAndView("book/list", "bookList", bookService.findAll(pageable));
    }

    @RequestMapping(value = "/borrow/{id}")
    public ModelAndView showBorrowForm(@PathVariable int id) {
        return new ModelAndView("book/borrow", "detailBook", bookService.findById(id));
    }

    @PostMapping(value = "/borrow/")
    public ModelAndView updateBorrowBook(@ModelAttribute Book detailBook) {
        if (detailBook.getAmount()!=0){
            detailBook.setAmount(detailBook.getAmount()-1);
            bookService.save(detailBook);
            String code = String.valueOf((int)(Math.random()*89999)+10000);
            Code newCode = new Code();
            newCode.setBook(detailBook);
            newCode.setCode(code);
            codeService.save(newCode);
            return new ModelAndView("/book/showCode","newCode",newCode);
        }else {
            throw new NullPointerException();
        }
    }
    @RequestMapping(value = "/give/{id}")
    public ModelAndView showGiveForm(@PathVariable int id) {
        return new ModelAndView("book/give", "detailBook", bookService.findById(id));
    }

    @PostMapping(value = "/give/")
    public ModelAndView updateGiveBook(@RequestParam("codeBorrow") String code) {
        Code deleteCode = codeService.findByCode(code);
        if (deleteCode!=null){
            Book book = deleteCode.getBook();
            book.setAmount(book.getAmount()+1);
            bookService.save(book);
            codeService.delete(deleteCode);
            return new ModelAndView("redirect:/book/list");
        }else {
            return new ModelAndView("book/error");
        }
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView showErrorPage(){
        return new ModelAndView("book/error1");
    }

}