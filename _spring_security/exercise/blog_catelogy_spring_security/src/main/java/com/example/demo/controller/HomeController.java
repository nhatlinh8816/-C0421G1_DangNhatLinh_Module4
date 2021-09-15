package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @RequestMapping(value = "/home")
    public ModelAndView getHomepage(){
        return new ModelAndView("home");
    }
    @RequestMapping(value = "/login")
    public ModelAndView getLoginPage(){
        return new ModelAndView("login");
    }
    @PostMapping(value = "/login")
    public ModelAndView getHomePage(){
        return new ModelAndView("home");
    }
}
