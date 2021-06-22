package com.codegym.comment.services;



import com.codegym.comment.models.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> showAll();

    void create(Comment comment);

    void update(Comment comment);

    Comment findById(Integer id);
}
