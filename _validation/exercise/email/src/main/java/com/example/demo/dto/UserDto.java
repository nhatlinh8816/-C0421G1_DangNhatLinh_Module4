package com.example.demo.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private int id;
    @NotBlank(message = "FIRST NAME MUST BE NOT EMPTY")
    @Size(min = 5, max = 45, message = "NAME LENGTH IS GREATER THAN 5 AND SMALLER 45")
    private String firstName;
    @NotBlank(message = "FIRST NAME MUST BE NOT EMPTY")
    @Size(min = 5, max = 45, message = "NAME LENGTH IS GREATER THAN 5 AND SMALLER 45")
    private String lastName;
    private String phoneNumber;
    @Min(value = 18,message = "AGE MUST BE NUMBER AND MUST NOT BE LESS Than 18")
    private int age;
    @Email(message ="EMAIL MUST BE LIKE THIS 'abc@xyz'" )
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto)target;
        String phoneNumber = userDto.getPhoneNumber();
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.forbidden","PHONE NUMBER MUST BE NUMBER FORMAT");
        }

    }
}
