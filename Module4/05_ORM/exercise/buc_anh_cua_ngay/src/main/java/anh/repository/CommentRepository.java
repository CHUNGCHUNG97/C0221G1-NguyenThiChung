package anh.repository;

import anh.model.entity.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> showAll();

    void create(Comment comment);

    void update(Comment comment);

    Comment findById(Integer id);

    void deletes(Integer[] ids);
}
