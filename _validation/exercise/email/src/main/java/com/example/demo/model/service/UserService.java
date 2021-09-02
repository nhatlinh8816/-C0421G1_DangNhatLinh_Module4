package com.example.demo.model.service;

import com.example.demo.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.util.List;

public interface UserService {
    Page<User>findAll(Pageable pageable);
//    List<User>findAll();
    void save(User user);
}
