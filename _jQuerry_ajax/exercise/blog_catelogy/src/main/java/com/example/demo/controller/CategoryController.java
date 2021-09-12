package com.example.demo.controller;


import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("category/list","categoryList",categoryService.findAll(pageable));
    }
    @RequestMapping(value = "/list/sort")
    public ModelAndView showListByDateCreate(@PageableDefault(value = 2,sort = "dateCreate",direction = Sort.Direction.ASC)Pageable pageable){
        return new ModelAndView("category/list","categoryList",categoryService.findAll(pageable));
    }
    @RequestMapping(value = "/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("category/create","newCategory",new Category());
    }
    @PostMapping(value = "/create")
    public  ModelAndView createCategory(@ModelAttribute Category category ){
        categoryService.save(category);
        return new ModelAndView("redirect:/category/list");
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        return new ModelAndView("category/delete","deleteCategory",categoryService.findById(id));
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteCategory(@ModelAttribute Category category ){
        categoryService.remove(category);
        return new ModelAndView("redirect:/category/list");
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable int id){
        return new ModelAndView("category/detail","detailCategory",categoryService.findById(id));
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("category/edit","editCategory",categoryService.findById(id));
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateCategory(@ModelAttribute Category editCategory ){
        categoryService.save(editCategory);
        return new ModelAndView("redirect:/category/list");
    }
}
