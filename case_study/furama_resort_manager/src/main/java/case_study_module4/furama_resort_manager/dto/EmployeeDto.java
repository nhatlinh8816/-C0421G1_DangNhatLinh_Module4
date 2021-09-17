package case_study_module4.furama_resort_manager.dto;

import case_study_module4.furama_resort_manager.model.entity.employee.Degree;
import case_study_module4.furama_resort_manager.model.entity.employee.Division;
import case_study_module4.furama_resort_manager.model.entity.employee.Position;
import case_study_module4.furama_resort_manager.model.entity.employee.User;
import case_study_module4.furama_resort_manager.validation.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EmployeeDto implements Validator {
    private int id;
    @NotBlank(message = "Must be not empty")
    private String name;
    @NotBlank(message = "Must be not empty")
    private String dOB;
    @NotBlank(message = "Must be not empty")
    private String identityNumber;
    private double salary;
    @NotBlank(message = "Must be not empty")
    private String phoneNumber;
    @NotBlank(message = "Must be not empty")
    @Email(message = "Email format is invalid")
    private String email;
    @NotBlank(message = "Must be not empty")
    private String address;
    @NotNull(message = "Must be not null")
    private User user;
    private Division division;
    private Position position;
    private Degree degree;

    public EmployeeDto() {
    }

    public EmployeeDto(int id, String name, String dOB, String identityNumber, double salary, String phoneNumber, String email, String address, User user, Division division, Position position, Degree degree) {
        this.id = id;
        this.name = name;
        this.dOB = dOB;
        this.identityNumber = identityNumber;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.user = user;
        this.division = division;
        this.position = position;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto)target;
        String identityNumber = employeeDto.getIdentityNumber();
        String phoneNumber = employeeDto.getPhoneNumber();
        String name = employeeDto.getName();
        if (!name.matches(Validation.NAME_PERSON_REGEX)){
            errors.rejectValue
                    ("name","contain.specialCharacter","Name is not contain special character. E.g: @ ; , . = - + , …");
        }
        if (!identityNumber.matches(Validation.IDENTITY_CARD_REGEX)){
            errors.rejectValue
                    ("identityNumber","identityNumber.invalid","Identity Number is invalid");
        }
        if (!phoneNumber.matches(Validation.PHONE_NUMBER_REGEX)){
            errors.rejectValue
                    ("phoneNumber","phoneNumber.invalid","Phone Number is invalid");
        }

    }
}
