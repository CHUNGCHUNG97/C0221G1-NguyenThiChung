package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;

    @GetMapping(value = "/home")
    public String home(Model model) {
        List<Blog> list = blogService.showAll();
        model.addAttribute("blogs", list);
        return "home";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute Blog blog) {
        blog.setDate(new Date(System.currentTimeMillis()));
        blogService.create(blog);
        return "redirect:/home";
    }

    @GetMapping(value = "/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }

    @PostMapping(value = "/edit/{id}")
    public String update(@ModelAttribute Blog blog, Model model) {
        blogService.update(blog);
        return "redirect:/home";
    }
    @GetMapping(value = "/delete/{id}")
    public String update(@PathVariable int id , Model model) {

        blogService.delete(blogService.findById(id));
        return "redirect:/home";
    }
}
