package com.example.demo.controller;

import com.example.demo.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@RequestMapping(value = "/customer")
@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "/list")
    public ModelAndView getListCustomer(){
        return new ModelAndView("list","customerList",customerService.findAll());
    }
}
