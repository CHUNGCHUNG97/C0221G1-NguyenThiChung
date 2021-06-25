package com.codegym.validation_form.model.service.impl;

import com.codegym.validation_form.model.entity.User;
import com.codegym.validation_form.model.repository.UserRepository;
import com.codegym.validation_form.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }
}
