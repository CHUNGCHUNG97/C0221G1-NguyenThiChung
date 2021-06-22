package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showAll();

    void create(Blog blog);

    void update(Blog blog);

    void delete(Blog blog);

    Blog findById(Integer id);
}
