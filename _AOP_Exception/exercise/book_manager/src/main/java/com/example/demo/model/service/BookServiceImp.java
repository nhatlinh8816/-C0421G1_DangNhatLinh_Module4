package com.example.demo.model.service;


import com.example.demo.model.entity.Book;
import com.example.demo.model.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class BookServiceImp implements BookService {
    @Autowired
    BookRepo bookRepo;


    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public Book findById(int id) {
        return bookRepo.findById(id).get();
    }
}


