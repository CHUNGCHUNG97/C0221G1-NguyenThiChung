package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.BlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> showAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public List<Blog> findByCategory(Category category) {
        return blogRepository.findAllByCategory(category);
    }

    @Override
    public void create(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
//        Blog blogInDB = blogRepository.findById(blog.getId()).orElse(null);
//        blogInDB.setAuthor(blog.getAuthor());
//        blogInDB.setContent(blog.getContent());
//        blogInDB.setDate(blog.getDate());
        blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
       try{
           String search = "%" + title.toLowerCase() + "%";
           return blogRepository.findAllByTitleContaining(search, pageable);
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }

    }
}
