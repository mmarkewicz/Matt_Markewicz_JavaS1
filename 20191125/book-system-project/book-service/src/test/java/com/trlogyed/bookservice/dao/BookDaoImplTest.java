package com.trlogyed.bookservice.dao;

import com.trlogyed.bookservice.models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookDaoImplTest {

    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() {
        List<Book> books = bookDao.getAllBooks();
        books.stream()
                .forEach(book -> bookDao.deleteBook(book.getId()));
    }

    @After
    public void tearDown() {
        List<Book> books = bookDao.getAllBooks();
        books.stream()
                .forEach(book -> bookDao.deleteBook(book.getId()));
    }

    @Test
    public void addGetDeleteBooks() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book = bookDao.addBook(book);

        assertEquals(book, bookDao.getBookById(book.getId()));

        bookDao.deleteBook(book.getId());
        assertEquals(0, bookDao.getAllBooks().size());
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book = bookDao.addBook(book);

        assertEquals(bookDao.getBookById(book.getId()).getTitle(), "Title");

        book.setTitle("New Title");
        bookDao.updateBook(book);

        assertEquals(bookDao.getBookById(book.getId()).getTitle(), "New Title");
    }

    @Test
    public void getAllBooks() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book = bookDao.addBook(book);

        Book book2 = new Book();
        book2.setTitle("New Title");
        book2.setAuthor("New Author");
        book2 = bookDao.addBook(book2);

        assertEquals(bookDao.getAllBooks().size(), 2);
    }
}