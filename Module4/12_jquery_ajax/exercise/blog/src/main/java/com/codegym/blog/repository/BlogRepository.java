package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
   @Query(value="select * from blogs where lower(title) like :search ",nativeQuery =true)
    Page<Blog> findAllByTitleContaining(@Param("search") String title, Pageable pageable);

    List<Blog> findAllByCategory(Category category);
}
