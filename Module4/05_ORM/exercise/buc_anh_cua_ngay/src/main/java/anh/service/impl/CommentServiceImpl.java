package anh.service.impl;

import anh.model.entity.Comment;
import anh.repository.CommentRepository;
import anh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> showAll() {
        return commentRepository.showAll();
    }

    @Override
    public void create(Comment comment) {
        commentRepository.create(comment);
    }

    @Override
    public void update(Comment comment) {
        commentRepository.update(comment);
    }

    @Override
    public Comment findById(Integer id) {
        return commentRepository.findById(id);
    }


}
