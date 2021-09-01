package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;
    @RequestMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("blog/list","blogList",blogService.findAll(pageable));
    }
    @RequestMapping(value = "/list/sort")
    public ModelAndView showListByDateCreate(@PageableDefault(value = 2,sort = "dateCreate",direction = Sort.Direction.ASC)Pageable pageable){
        return new ModelAndView("blog/list","blogList",blogService.findAll(pageable));
    }
    @RequestMapping(value = "/create")
    public String showCreateForm(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("newBlog",new Blog());
        return ("blog/create");
    }
    @PostMapping(value = "/create")
    public  ModelAndView createBlog(@ModelAttribute Blog blog ){
        blog.setDateCreate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        return new ModelAndView("redirect:/blog/list");
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        return new ModelAndView("blog/delete","deleteBlog",blogService.findById(id));
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteBlog(@ModelAttribute Blog blog ){
        blogService.remove(blog);
        return new ModelAndView("redirect:/blog/list");
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable int id){
        return new ModelAndView("blog/detail","detailBlog",blogService.findById(id));
    }

    @RequestMapping(value = "/edit/{id}")
    public String showEditForm(@PathVariable int id,Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("editBlog",blogService.findById(id));
        return ("blog/edit");
//        return new ModelAndView("blog/edit","editBlog",blogService.findById(id));
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateBlog(@ModelAttribute Blog editBlog ){
        editBlog.setDateCreate(new Date(System.currentTimeMillis()));
        blogService.save(editBlog);
        return new ModelAndView("redirect:/blog/list");
    }
    @PostMapping(value = "/searchByDes")
    public ModelAndView showListByDes(@RequestParam("blogDes") String des, @PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("blog/list","blogList",blogService.findByDescription(des, pageable));
    }
}
