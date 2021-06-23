package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> showAll(Pageable pageable);

    void create(Blog blog);

    void update(Blog blog);

    void delete(Blog blog);

    Blog findById(Integer id);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

}
