package com.codegym.validation_form.model.service;

import com.codegym.validation_form.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create(User user);
}
