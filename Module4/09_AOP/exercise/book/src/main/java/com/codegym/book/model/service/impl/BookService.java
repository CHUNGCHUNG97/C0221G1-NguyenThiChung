package com.codegym.book.model.service.impl;

import com.codegym.book.model.Repository.BookRepository;
import com.codegym.book.model.Repository.BorrowBookRepository;
import com.codegym.book.model.entity.Book;
import com.codegym.book.model.entity.BorrowBook;
import com.codegym.book.model.service.BookException;
import com.codegym.book.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BorrowBookRepository borrowBookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public String returnBook(int idBook, long code) throws BookException {
        Book book = bookRepository.findById(idBook).orElse(null);
        if(book==null){
            throw new BookException("Không tồn tại book");
        }
        BorrowBook borrowBook = borrowBookRepository.findAllByCodeAndBook(code,book);
        if(borrowBook==null){
            throw new BookException("Mã code không tồn tại");
        }
        book.setQuantity(book.getQuantity()+1);
        bookRepository.save(book);
        borrowBookRepository.delete(borrowBook);
        return "Trả sách thành công";

    }


}
