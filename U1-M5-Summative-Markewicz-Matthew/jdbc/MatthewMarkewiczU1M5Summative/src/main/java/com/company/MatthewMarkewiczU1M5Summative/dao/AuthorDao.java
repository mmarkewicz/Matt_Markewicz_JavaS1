package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Author;

import java.util.List;

public interface AuthorDao {
    // get author
    Author getAuthor(int id);
    // get all authors
    List<Author> getAllAuthors();
    // add author
    Author addAuthor(Author author);
    // update author
    void updateAuthor(Author author);
    // delete author
    void deleteAuthor(int id);
}
