package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/list")
    public ModelAndView viewAll(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("user/list","userList",userService.findAll(pageable));
    }

    @RequestMapping(value = "/create")
    public String showCreateForm(Model model){
        model.addAttribute("newUserDto",new UserDto());
        return ("user/create");
    }

    @PostMapping(value = "/create")
    public  ModelAndView createUser(@Validated @ModelAttribute ("newUserDto")  UserDto newUserDto, BindingResult bindingResult,Model model){
        new UserDto().validate(newUserDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("user/create");
        }else {
            //chuyen dto thanh entity
            User user = new User();
            BeanUtils.copyProperties(newUserDto,user);
            userService.save(user);
            return new ModelAndView("/user/result");
        }

    }
}
