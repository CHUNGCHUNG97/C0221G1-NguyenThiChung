package com.codegym.comment.repositories;

import com.codegym.comment.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    Một cái là đối tượng, cái sau là ID của đối tượng ở dạng Object


    //    Muốn tìm tất cả bởi 1 cái gì đó thì làm theo format của nó
    List<Comment> findAllByCreatedDate(Date date);

    //  tìm tất cả comment bởi ngày tạo và tên author
    List<Comment> findAllByCreatedDateAndAuthor(Date date, String author);
}
