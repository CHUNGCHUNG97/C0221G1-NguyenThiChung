package anh.service;

import anh.model.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> showAll();

    void create(Comment comment);

    void update(Comment comment);

    Comment findById(Integer id);
}
