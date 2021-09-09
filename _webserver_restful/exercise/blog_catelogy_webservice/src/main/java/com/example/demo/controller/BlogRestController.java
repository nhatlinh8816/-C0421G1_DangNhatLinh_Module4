package com.example.demo.controller;


import com.example.demo.dto.BlogDto;
import com.example.demo.model.Blog;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/blog/api/")
public class BlogRestController {
    @Autowired
    private BlogService blogService;
    private CategoryService categoryService;
//    Xem danh sách các bài viết
    @GetMapping
    //khong co view nen phai tra ve ResponseEntity
    public ResponseEntity<List<Blog>> getBlogList(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @PostMapping
    //ben t3 se gui 1 doi tuong blogDto, dung RequestBody de bat lai
    public ResponseEntity addBlog(@RequestBody BlogDto blogDto){
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        blogService.save(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable int id,@RequestBody BlogDto blogDto){
        Blog currentBlog = blogService.findById(id);
        if (currentBlog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentBlog.setDescription(blogDto.getDescription());
        currentBlog.setContent(blogDto.getContent());
       currentBlog.setCategory(blogDto.getCategory());
       blogService.save(currentBlog);
        return new ResponseEntity(HttpStatus.OK);
    }
    //Xem danh sách các bài viết của một category
    @GetMapping(value = "/search")
    public ResponseEntity<List<Blog>> searchByCategoryId(@RequestParam int categoryId){
        List<Blog> blogList = blogService.findByCategory(categoryId);
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

//   Xem chi tiết một bài viết
    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
