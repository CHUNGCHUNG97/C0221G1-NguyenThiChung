package com.codegym.comment.services.impl;


import com.codegym.comment.models.Comment;
import com.codegym.comment.repositories.CommentRepository;
import com.codegym.comment.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> showAll() {

//        Nó có sẵn findAll
        return commentRepository.findAllByCreatedDate(new Date(System.currentTimeMillis()));
    }

    @Override
    public void create(Comment comment) {

        commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment findById(Integer id) {
//        Vì tìm theo Id có khả năng k có. nên phải orElseNull cho nó
        return commentRepository.findById(id).orElse(null)
                ;

    }


}
