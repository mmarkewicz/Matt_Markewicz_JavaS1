package com.company.MatthewMarkewiczU1M5Summative.dao;

import com.company.MatthewMarkewiczU1M5Summative.models.Publisher;
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
public class PublisherDaoTest {

    @Autowired
    PublisherDao publisherDao;

    @Before
    public void setUp() throws Exception {
//        List<Publisher> publisherList = publisherDao.getAllPublishers();
//        publisherList.stream()
//                .forEach(publisher -> publisherDao.deletePublisher(publisher.getPublisher_id()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAddDeletePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Test Pub");
        publisher.setStreet("Test St");
        publisher.setCity("Jersey City");
        publisher.setState("NJ");
        publisher.setPostal_code("11111");
        publisher.setPhone("555-555-5555");
        publisher.setEmail("test@test.com");
        publisher = publisherDao.addPublisher(publisher);

        Publisher publisher2 = publisherDao.getPublisher(publisher.getPublisher_id());

        assertEquals(publisher, publisher2);
    }

    @Test
    public void updatePublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Test Pub");
        publisher.setStreet("Test St");
        publisher.setCity("Jersey City");
        publisher.setState("NJ");
        publisher.setPostal_code("11111");
        publisher.setPhone("555-555-5555");
        publisher.setEmail("test@test.com");
        publisher = publisherDao.addPublisher(publisher);

        publisher.setName("TESTING TESTING");
        publisherDao.updatePublisher(publisher);

        assertEquals(publisherDao.getPublisher(publisher.getPublisher_id()).getName(), "TESTING TESTING");
    }

    @Test
    public void getAllPublishers() {

        List<Publisher> initialPublisherList = publisherDao.getAllPublishers();

        Publisher publisher = new Publisher();
        publisher.setName("Test Pub");
        publisher.setStreet("Test St");
        publisher.setCity("Jersey City");
        publisher.setState("NJ");
        publisher.setPostal_code("11111");
        publisher.setPhone("555-555-5555");
        publisher.setEmail("test@test.com");

        Publisher publisher2 = new Publisher();
        publisher2.setName("Test Pub");
        publisher2.setStreet("Test St");
        publisher2.setCity("Jersey City");
        publisher2.setState("NJ");
        publisher2.setPostal_code("11111");
        publisher2.setPhone("555-555-5555");
        publisher2.setEmail("test@test.com");

        List<Publisher> publisherList = publisherDao.getAllPublishers();

        assertEquals(publisherList.size(), initialPublisherList.size() + 2);
    }
}
