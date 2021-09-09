package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImp implements BlogService {
    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findAll(pageable);
    }

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

    @Override
    public Page<Blog> findByDescription(String name,Pageable pageable) {
        return blogRepo.findByDescription(name,pageable);
    }

    @Override
    public List<Blog> findByCategory(int categoryId) {
        return blogRepo.findByCategory_Id(categoryId);
    }


}
