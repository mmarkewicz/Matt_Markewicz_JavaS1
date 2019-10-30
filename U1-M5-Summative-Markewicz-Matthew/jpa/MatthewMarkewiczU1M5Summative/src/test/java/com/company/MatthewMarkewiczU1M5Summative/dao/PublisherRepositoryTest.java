package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.dto.Author;
import com.company.MatthewMarkewiczU1M5Summative.dto.Publisher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PublisherRepository publisherRepository;

    @Before
    public void setUp() {
        bookRepository.deleteAll();
        publisherRepository.deleteAll();
        authorRepository.deleteAll();
    }

    @Test
    @Transactional
    public void shouldAddAndFindByID() {
       Publisher publisher = new Publisher();
       publisher.setName("Test Pub");
       publisher.setStreet("Main St.");
       publisher.setCity("Jersey City");
       publisher.setState("NJ");
       publisher.setPostal_code("10101");
       publisher.setPhone("555-555-5555");
       publisher.setEmail("test@email.com");

       publisher = publisherRepository.save(publisher);

       Publisher publisherFromRepo = publisherRepository.getOne(publisher.getPublisher_id());

       assertEquals(publisher, publisherFromRepo);
    }

}
