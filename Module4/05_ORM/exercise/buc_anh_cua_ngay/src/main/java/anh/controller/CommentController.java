package anh.controller;

import anh.model.entity.Comment;
import anh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/comment",produces = "text/plain;charset=UTF-8")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping(value = "")
    public String home(Model model) {
        List<Comment> list = commentService.showAll();
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", list);
        return "create";
    }

    @PostMapping(value = "/save")
    public String saveComment(@ModelAttribute Comment comment) {
        commentService.create(comment);
        return "redirect:/comment";
    }


    @GetMapping(value = "/like/{id}")
    public String updateComment(@PathVariable int id) {
        Comment comment = commentService.findById(id);
        comment.setLikes(comment.getLikes()+1);
        commentService.update(comment);
        return "redirect:/comment";
    }
}
