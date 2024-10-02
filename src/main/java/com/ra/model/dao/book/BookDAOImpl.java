package com.ra.model.dao.book;

import com.ra.database.ConnectionDB;
import com.ra.model.entity.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDAOImpl implements BookDAO{
    @Override
    public List<Book> findAll() {
        Connection connection = null;
        List<Book> books = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            String sql = "SELECT * FROM books";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescription(resultSet.getString("description"));
                books.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return books;
    }

    @Override
    public Boolean create(Book book) {
        Connection connection = null;

        try {
            connection = ConnectionDB.openConnection();
            CallableStatement statement = connection.prepareCall("{call proc_add_book(?,?,?,?)}");
            statement.setString(1,book.getTitle());
            statement.setString(2,book.getAuthor());
            statement.setDouble(3,book.getPrice());
            statement.setString(4,book.getDescription());
            if(statement.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;

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
