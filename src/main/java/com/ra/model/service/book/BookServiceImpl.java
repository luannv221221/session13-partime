package com.ra.model.service.book;

import com.ra.model.dao.book.BookDAO;
import com.ra.model.dao.book.BookDAOImpl;
import com.ra.model.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Boolean create(Book book) {
        return bookDAO.create(book);
    }

    @Override
    public Book findById(int id) {
        return null;
    }

    @Override
    public Boolean update(Book book) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
