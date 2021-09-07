package com.example.demo.model.service;

import com.example.demo.model.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);
    void save(Book book);
    Book findById(int id);

}
