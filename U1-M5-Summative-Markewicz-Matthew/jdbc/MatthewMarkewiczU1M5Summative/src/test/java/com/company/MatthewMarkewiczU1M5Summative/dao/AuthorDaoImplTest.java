package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Author;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AuthorDaoImplTest {

    @Autowired
    protected AuthorDao authorDao;

    @Before
    public void setUp() throws Exception {
//        List<Author> authorList = authorDao.getAllAuthors();
//        authorList.stream()
//                .forEach(author -> authorDao.deleteAuthor(author.getAuthor_id()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteAuthor() {
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

        Author author2 = authorDao.getAuthor(author.getAuthor_id());

        assertEquals(author, author2);
    }

    @Test
    public void getAllAuthors() {
        int intitialSize = authorDao.getAllAuthors().size();

        // author 1
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

        // author 2
        Author author2 = new Author();
        author2.setFirst_name("Charles");
        author2.setLast_name("Dickens");
        author2.setStreet("Main Street");
        author2.setCity("New York");
        author2.setState("NY");
        author2.setPostal_code("00000");
        author2.setPhone("(555) 555-5555");
        author2.setEmail("test@email.com");
        author2 = authorDao.addAuthor(author2);

        // compare new size to initial size + the two authors we just added
        assertEquals(authorDao.getAllAuthors().size(), intitialSize + 2);
    }

    @Test
    public void updateAuthor() {
        // author 1
        Author author = new Author();
        author.setFirst_name("Charles");
        author.setLast_name("Dickens");
        author.setStreet("Main Street");
        author.setCity("New York");
        author.setState("NY");
        author.setPostal_code("00000");
        author.setPhone("(555) 555-5555");
        author.setEmail("test@email.com");
        author = authorDao.addAuthor(author); // add new author to db

        author.setFirst_name("TESTING");
        authorDao.updateAuthor(author); // update author id in db

        author = authorDao.getAuthor(author.getAuthor_id()); // reassign value of author to read newly added author

        // assert that the last author in the table's first name is UPDATE, not "Charles"
        assertEquals(author.getFirst_name(), "TESTING");
    }
}
