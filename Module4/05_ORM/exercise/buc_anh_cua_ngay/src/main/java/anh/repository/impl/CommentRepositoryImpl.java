package anh.repository.impl;

import anh.model.entity.Comment;
import anh.repository.DataBaseRepository;
import anh.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
    @Autowired
    DataBaseRepository dataBaseRepository;


    @Override
    public List<Comment> showAll() {
        return DataBaseRepository.entityManager.createQuery("select c from Comment as c", Comment.class).getResultList();

    }

    @Override
    public void create(Comment comment) {
        EntityTransaction entityTransaction = DataBaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        DataBaseRepository.entityManager.persist(comment);
        entityTransaction.commit();
    }

    @Override
    public void update(Comment comment) {
        EntityTransaction entityTransaction = DataBaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        DataBaseRepository.entityManager.persist(comment);
        entityTransaction.commit();
    }

    @Override
    public Comment findById(Integer id) {

        String findById = "SELECT * FROM comments where id = :id limit 1";
        Query query = DataBaseRepository.entityManager.createNativeQuery(findById, Comment.class);
        query.setParameter("id", id);
        return (Comment) query.getSingleResult();


    }

    @Override
    public void deletes(Integer[] ids) {

    }


}
