package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Book;

import java.util.List;

public interface BookDao {
    Book getBook(int id);
    List<Book> getAllBooks();
    Book addBook(Book book);
    void updateBook(Book book);
    void deleteBook(Book book);

    // get books by author
    List<Book> getBooksByAuthor(int author_id);
}
