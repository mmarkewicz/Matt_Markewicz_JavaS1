package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    // prepared statements
    private static final String INSERT_BOOK_SQL =
            "INSERT INTO book (isbn, publish_date, author_id, title, publish_id, price) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BOOK_SQL =
            "SELECT * FROM book WHERE book_id = ?";
    private static final String SELECT_ALL_BOOKS_SQL =
            "SELECT * FROM book";
    private static final String DELETE_BOOK_SQL =
            "DELETE FROM book WHERE book_id = ?";
    private static final String UPDATE_BOOK_SQL =
            "UPDATE book SET isbn = ?, publish_date = ?, author_id = ?, title = ?, publish_id = ?, price = ? WHERE book_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBook(int id) {
        return jdbcTemplate.queryForObject(SELECT_BOOK_SQL, this::mapRowToBook, id);
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublish_date(),
                book.getPrice()
        );

        int id = jdbcTemplate.queryForObject("SELECT last_insert_id()", Integer.class);
        book.setBook_id(id);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getIsbn(),
                book.getPublish_date(),
                book.getAuthor_id(),
                book.getTitle(),
                book.getPublish_id(),
                book.getPrice(),
                book.getBook_id()
                );
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    @Override
    public List<Book> getBooksByAuthor(int author_id) {
        return null;
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setBook_id(rs.getInt("book_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setAuthor_id(rs.getInt("author_id"));
        book.setPrice(rs.getDouble("price"));
        book.setPublish_date(rs.getDate("publish_date"));
        book.setPublish_id(rs.getInt("publish_id"));
        book.setTitle(rs.getString("title"));
        return book;
    }
}
