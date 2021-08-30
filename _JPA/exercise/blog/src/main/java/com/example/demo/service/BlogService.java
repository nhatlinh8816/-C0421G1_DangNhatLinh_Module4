package com.example.demo.service;

import com.example.demo.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void remove(Blog blog);

}
