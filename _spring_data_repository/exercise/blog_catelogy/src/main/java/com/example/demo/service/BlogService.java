package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void remove(Blog blog);

}
