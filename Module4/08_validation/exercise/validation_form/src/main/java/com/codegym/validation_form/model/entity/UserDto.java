package com.codegym.validation_form.model.entity;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class UserDto {

    @NotEmpty(message = "please input first name")
    @NotBlank
    @Size(min = 5, max = 45 ,message = "length min is 5 and length max is 45")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "please input first name")
    @NotBlank
    @Size(min = 5, max = 45,message = "length min is 5 and length max is 45")
    @Column(name = "last_name")
    private String lastName;
    @Pattern(regexp = "^[(](\\+)+[0-9]{2}[)]+([0-9]{9})$",message = "number is not valid")
    private String phone;
    @Email(message = "email is not valid")
    private String email;

    @Min(value = 18,message = "age have to >=18")
    private int age;

    public UserDto() {
    }

    public UserDto(@NotEmpty @Size(min = 5, max = 45) String firstName, @Size(min = 5, max = 45) String lastName, @Pattern(regexp = "^[(]0+[0-9]{1}[)]+([0-9]{8})$") String phone, @Email String email, @Min(18) int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.age = age;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
