package com.ra.model.dao.book;

import com.ra.model.entity.Book;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();
    Boolean create(Book book);
    Book findById(int id);
    Boolean update(Book book);
    void  delete(int id);
}
