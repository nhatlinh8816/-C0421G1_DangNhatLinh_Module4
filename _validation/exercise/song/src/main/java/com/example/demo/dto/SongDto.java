package com.example.demo.dto;

import com.example.demo.model.entity.Song;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto implements Validator {
    private Integer id;
    @NotBlank(message = "Name of Song must be not empty")
    @Size(max = 800,message = "Name of Song must be less than 800 character")
    private String name;
    @NotBlank(message = "Name of Singer must be not empty")
    @Size(max = 300, message = "Name of Singer must be less than 300 character")
    private String singer;
    @NotBlank(message = "Category must be not empty")
    @Size(max = 1000, message = "Category must be less than 1000 character")
    private String category;

    public SongDto() {
    }

    public SongDto(Integer id, @NotBlank(message = "Name of Song must be not empty") @Size(max = 800, message = "Name of Song must be less than 800 character") String name, @NotBlank(message = "Name of Singer must be not empty") @Size(max = 300, message = "Name of Singer must be less than 300 character") String singer, @NotBlank(message = "Category must be not empty") @Size(max = 1000, message = "Category must be less than 1000 character") String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        //ep kieu SongDto sang kieu target
        SongDto songDto =(SongDto)target;
        String name = songDto.getName();
        String singer = songDto.getSinger();
        String category = songDto.getCategory();
        if (!name.matches("([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})|(\\s[0-9])){0,5}$")){
            errors.rejectValue
                    ("name","contain.specialCharacter","Name of song is not contain special character. E.g: @ ; , . = - + , …");
        }
        if (!singer.matches("([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$")){
            errors.rejectValue
                    ("singer","contain.specialCharacter","Name of singer is not contain special character. E.g: @ ; , . = - + , …");
        }
        if (!category.matches("([\\p{Lu}|,][\\p{Ll}|,]{1,8})(\\s([\\p{Lu}|,]|[\\p{Lu}|,][\\p{Ll}|,]{1,10})){0,5}$")){
            errors.rejectValue
                    ("category","contain.specialCharacterExcept','","Name of category is not contain special character except ','. E.g: @ ; . = - + , …");
        }
    }
}
