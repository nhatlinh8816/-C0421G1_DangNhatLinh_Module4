package com.example.demo.dto;


import com.example.demo.model.Category;

import java.util.Date;


public class BlogDto {
    private int id;
    private String description;
    private String content;
    private Category category;


    public BlogDto() {
    }

    public BlogDto(int id, String description, String content, Date dateCreate) {
        this.id = id;
        this.description = description;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
