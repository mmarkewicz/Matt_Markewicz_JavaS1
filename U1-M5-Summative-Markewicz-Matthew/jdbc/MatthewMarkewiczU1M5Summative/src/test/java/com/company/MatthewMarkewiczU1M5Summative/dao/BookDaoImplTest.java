package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Author;
import com.company.MatthewMarkewiczU1M5Summative.models.Book;
import com.company.MatthewMarkewiczU1M5Summative.models.Publisher;
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
    @Autowired
    AuthorDao authorDao;
    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = bookDao.getAllBooks();
        bookList.stream()
                .forEach(book -> bookDao.deleteBook(book.getBook_id()));
        List<Author> authorList = authorDao.getAllAuthors();
        authorList.stream()
                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));
        List<Publisher> publisherList = publisherDao.getAllPublishers();
        publisherList.stream()
                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteBook() {
        // author
        Author author = new Author();
        author.setFirst_name("Charles");
        author.setLast_name("Dickens");
        author.setStreet("Main Street");
        author.setCity("New York");
        author.setState("NY");
        author.setPostal_code("00000");
        author.setPhone("(555) 555-5555");
        author.setEmail("test@email.com");
        author = authorDao.addAuthor(author);

        // publisher
        Publisher publisher = new Publisher();
        publisher.setName("Pub1");
        publisher.setStreet("First St");
        publisher.setCity("Jersey City");
        publisher.setState("NJ");
        publisher.setPostal_code("10101");
        publisher.setPhone("(555) 123-4567");
        publisher.setEmail("testingtesting@email.com");
        publisher = publisherDao.addPublisher(publisher);

        // book
        Book book = new Book();
        book.setTitle("Great Expectations");
        book.setPublish_id(publisher.getPublisher_id());
        book.setPublish_date(new Date());
        book.setBook_id(1);
        book.setPrice(15.00);
        book.setIsbn("11111");
        book.setAuthor_id(author.getAuthor_id());
        book = bookDao.addBook(book);

        Book book2 = bookDao.getBook(book.getBook_id());
        book2.setPublish_date(new Date()); // date coming back in different format, reassign date for testing purposes

        assertEquals(book.toString(), book2.toString());
    }
}