package com.trlogyed.bookservice.dao;

import com.trlogyed.bookservice.models.Book;

import java.util.List;

public interface BookDao {
    Book getBookById(int id);
    List<Book> getAllBooks();
    Book addBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
}
