package com.example.demo.model.service;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.repository.CustomerRepo;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
}
