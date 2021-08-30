package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @RequestMapping(value = "/list")
    public ModelAndView showList(){
        return new ModelAndView("list","blogList",blogService.findAll());
    }
    @RequestMapping(value = "/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("create","newBlog",new Blog());
    }
    @PostMapping(value = "/create")
    public  ModelAndView createBlog(@ModelAttribute Blog blog ){
        blogService.save(blog);
        return new ModelAndView("redirect:/blog/list");
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        return new ModelAndView("delete","deleteBlog",blogService.findById(id));
    }

    @PostMapping(value = "/delete")
    public ModelAndView deleteBlog(@ModelAttribute Blog blog ){
        blogService.remove(blog);
        return new ModelAndView("redirect:/blog/list");
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView showDetailForm(@PathVariable int id){
        return new ModelAndView("detail","detailBlog",blogService.findById(id));
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        return new ModelAndView("edit","editBlog",blogService.findById(id));
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateBlog(@ModelAttribute Blog editBlog ){
        blogService.save(editBlog);
        return new ModelAndView("redirect:/blog/list");
    }
}
