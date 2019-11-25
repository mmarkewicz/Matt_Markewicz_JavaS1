package com.trlogyed.bookservice.service;

import com.trlogyed.bookservice.dao.BookDao;
import com.trlogyed.bookservice.models.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BookServiceLayerTest {

    BookServiceLayer bookServiceLayer;

    @Mock
    BookDao bookDao;

    @Before
    public void setUp() {
        setUpBookMocks();

//        bookServiceLayer = new BookServiceLayer(bookDao);
    }

    @Test
    public void fetchBookById() {
//        Book book = new Book();
//        book.setId(5);
//        book.setTitle("Title");
//        book.setAuthor("Author");
//
//        assertEquals(book.toString(), bookServiceLayer.fetchBookById(5).toString());
    }

    @Test
    public void fetchAllBooks() {
//        Book book = new Book();
//        book.setId(5);
//        book.setTitle("Title");
//        book.setAuthor("Author");
//
//        List<Book> bookList = new ArrayList<>();
//        bookList.add(book);
//
//        assertEquals(bookList.toString(), bookServiceLayer.fetchAllBooks().toString());
    }

    @Test
    public void addBook() {
//        Book book = new Book();
//        book.setId(5);
//        book.setTitle("Title");
//        book.setAuthor("Author");
//
//        Book bookWithoutId = new Book();
//        bookWithoutId.setTitle("Title");
//        bookWithoutId.setAuthor("Author");
//
//        assertEquals(book.toString(), bookServiceLayer.addBook(bookWithoutId).toString());
    }

    private void setUpBookMocks() {
        Book book = new Book();
        book.setId(5);
        book.setTitle("Title");
        book.setAuthor("Author");

        Book bookWithoutId = new Book();
        bookWithoutId.setTitle("Title");
        bookWithoutId.setAuthor("Author");

        List<Book> bookList = new ArrayList<>();
        bookList.add(book);

        doReturn(book).when(bookDao).addBook(bookWithoutId);
        doReturn(book).when(bookDao).getBookById(5);
        doReturn(bookList).when(bookDao).getAllBooks();
    }

}
