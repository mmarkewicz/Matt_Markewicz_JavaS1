package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookDaoImplTest {

    @Autowired
    BookDao bookDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = bookDao.getAllBooks();
        bookList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBook_id()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteBook() {

        // must add author and publisher to db since they are foreign keys
        
        Book book = new Book();
        book.setTitle("Great Expectations");
        book.setPublish_id(1);
        book.setPublish_date(new Date());
        book.setBook_id(1);
        book.setPrice(15.00);
        book.setIsbn("11111");
        book.setAuthor_id(1);
        book = bookDao.addBook(book);

        Book book2 = bookDao.getBook(book.getBook_id());

        assertEquals(book, book2);
    }
}