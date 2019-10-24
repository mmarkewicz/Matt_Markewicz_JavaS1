package com.company.CoffeeInventoryDAOMatthewMarkewicz.dao;

import com.company.CoffeeInventoryDAOMatthewMarkewicz.model.Roaster;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RoasterDAOTest {

    @Autowired
    RoasterDAO dao;

    Roaster testRoaster = new Roaster();

    @Before
    public void setUp() throws Exception {
        List<Roaster> rList = dao.getAllRoasters();

        rList.stream()
                .forEach(roaster -> dao.deleteRoaster(roaster.getRoaster_id()));

        Roaster testRoaster = new Roaster();
        testRoaster.setName("Test Roaster");
        testRoaster.setStreet("Bluegrass Blvd");
        testRoaster.setCity("Branchburg");
        testRoaster.setState("NJ");
        testRoaster.setPostal_code("08876");
        testRoaster.setPhone("555-555-5555");
        testRoaster.setEmail("roaster@test.com");
        testRoaster.setNote("Testing testing...");
    }

    @Test
    void getRoaster() {
        testRoaster.setRoaster_id(1);
        assertEquals(testRoaster, dao.getRoaster(1));
    }

    @Test
    void getAllRoasters() {
        testRoaster.setRoaster_id(1);
        List<Roaster> roasterTestList = new ArrayList<>();
        roasterTestList.add(testRoaster);
        assertEquals(roasterTestList, dao.getAllRoasters());
    }

    @Test
    void addRoaster() {
        dao.addRoaster(testRoaster);
        assertEquals(dao.getAllRoasters().size(), 2);
    }

    @Test
    void updateRoaster() {
        testRoaster.setRoaster_id(1);
        testRoaster.setNote("Successfully updated");
        dao.updateRoaster(testRoaster);
        assertEquals(dao.getRoaster(1).getNote(), "Successfully updated");
    }

    @Test
    void deleteRoaster() {
        dao.deleteRoaster(1);
        assertEquals(dao.getAllRoasters().size(), 0);
    }
}