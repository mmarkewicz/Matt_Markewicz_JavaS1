package com.trlogyed.bookservice.dao;

import com.trlogyed.bookservice.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    // prepared statements
    private static final String SELECT_ALL_BOOKS_SQL =
            "SELECT * FROM book";

    private static final String SELECT_BOOK_BY_ID_SQL =
            "SELECT * FROM book WHERE book_id = ?";

    private static final String INSERT_BOOK_SQL =
            "INSERT INTO book(title, author) VALUES (?, ?)";

    private static final String UPDATE_BOOK_SQL =
            "UPDATE book SET title = ?, author = ? WHERE book_id = ?";

    private static final String DELETE_BOOK_SQL =
            "DELETE FROM book WHERE book_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book getBookById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BOOK_BY_ID_SQL, this::mapRowToBook, id);
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query(SELECT_ALL_BOOKS_SQL, this::mapRowToBook);
    }

    @Override
    public Book addBook(Book book) {
        jdbcTemplate.update(INSERT_BOOK_SQL,
                book.getTitle(),
                book.getAuthor()
                );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        book.setId(id);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        jdbcTemplate.update(UPDATE_BOOK_SQL,
                book.getTitle(),
                book.getAuthor(),
                book.getId()
                );
    }

    @Override
    public void deleteBook(int id) {
        jdbcTemplate.update(DELETE_BOOK_SQL, id);
    }

    private Book mapRowToBook(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("book_id"));
        book.setAuthor(rs.getString("author"));
        book.setTitle(rs.getString("title"));
        return book;
    }
}
