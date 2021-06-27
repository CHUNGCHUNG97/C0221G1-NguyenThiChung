package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService blogService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping(value = "/home")
    public String home(@RequestParam(required = false) String search,
                       @RequestParam(required = false) Integer page,
                       @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                       @RequestParam(required = false) Integer pageSize, Model model) {
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by("date").ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by("date").descending();
        }
        if (page == null) {
            page = 0;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        Page<Blog> list;
        if (search != null) {
            assert sortable != null;
            list = blogService.findAllByTitleContaining(search, PageRequest.of(page, pageSize, sortable));
        } else {
            assert sortable != null;
            list = blogService.showAll(PageRequest.of(page, pageSize, sortable));
        }
        model.addAttribute("blogs", list);
        model.addAttribute("search", search);
        model.addAttribute("categories", categoryService.findAll());
        return "home";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryService.findAll());
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
        model.addAttribute("categories", categoryService.findAll());
        return "view";
    }

    @PostMapping(value = "/edit/{id}")
    public String update(@ModelAttribute Blog blog, Model model) {
        blogService.update(blog);
        return "redirect:/home";
    }

    @GetMapping(value = "/delete/{id}")
    public String update(@PathVariable int id, Model model) {

        blogService.delete(blogService.findById(id));
        return "redirect:/home";
    }
}
