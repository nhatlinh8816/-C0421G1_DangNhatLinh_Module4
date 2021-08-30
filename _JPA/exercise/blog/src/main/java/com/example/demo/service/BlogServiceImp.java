package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepo blogRepo;
    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).get();
    }

    @Override
    public void remove(Blog blog) {
        blogRepo.delete(blog);
    }


}
