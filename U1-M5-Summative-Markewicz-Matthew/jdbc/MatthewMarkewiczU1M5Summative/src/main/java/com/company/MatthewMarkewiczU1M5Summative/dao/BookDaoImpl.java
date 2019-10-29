package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public Book getBook(int id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book addBook(Book book) {
        return null;
    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void deleteBook(Book book) {

    }

    @Override
    public List<Book> getBooksByAuthor(int author_id) {
        return null;
    }
}
