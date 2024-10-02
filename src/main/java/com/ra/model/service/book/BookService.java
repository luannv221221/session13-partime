package com.ra.model.service.book;

import com.ra.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Boolean create(Book book);
    Book findById(int id);
    Boolean update(Book book);
    void  delete(int id);
}
