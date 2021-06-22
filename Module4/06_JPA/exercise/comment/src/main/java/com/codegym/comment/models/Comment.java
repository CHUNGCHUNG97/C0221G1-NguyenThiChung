package com.codegym.comment.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int rating;
    private String author;
    @Column(name="feedback", columnDefinition = "varchar(1000)")
    private String feedback;
    private int likes;
    @Column(name = "created_date")
    private Date createdDate = new Date(System.currentTimeMillis());

    public Comment() {
    }

    public Comment(int id, int rating, String author, String feedback, int likes, Date date) {
        this.id = id;
        this.rating = rating;
        this.author = author;
        this.feedback = feedback;
        this.likes = likes;
        this.createdDate = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
