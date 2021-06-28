package com.codegym.book.model.service;

import com.codegym.book.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void save(Book book);

    String returnBook(int idBook, long code) throws BookException;
}
