package com.example.demo.model.service;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public List<Customer> findAll() {
       return customerRepo.findAll();
    }
}
