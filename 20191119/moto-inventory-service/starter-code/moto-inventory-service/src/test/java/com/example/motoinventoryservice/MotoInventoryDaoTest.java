package com.example.motoinventoryservice;

import com.example.motoinventoryservice.dao.MotoInventoryRepository;
import com.example.motoinventoryservice.model.Motorcycle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MotoInventoryDaoTest {

    @Autowired
    protected MotoInventoryRepository motoInventoryRepository;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Motorcycle> mList = motoInventoryRepository.findAll();

        mList.stream()
                .forEach(motorcycle -> motoInventoryRepository.deleteById(motorcycle.getId()));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addGetDeleteMotorcycle() {

        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        moto = motoInventoryRepository.save(moto);

        Motorcycle moto2 = motoInventoryRepository.getOne(moto.getId());

        assertEquals(moto, moto2);

        motoInventoryRepository.deleteById(moto.getId());

        moto2 = motoInventoryRepository.getOne(moto.getId());

        assertNull(moto2);
    }

    @Test
    public void getAllMotorcycles() {

        Motorcycle moto = new Motorcycle();
        moto.setVin("22222");
        moto.setMake("Honda");
        moto.setModel("CB300");
        moto.setYear("2019");
        moto.setColor("red");

        moto = motoInventoryRepository.save(moto);

        Motorcycle moto2 = new Motorcycle();
        moto2.setVin("33333");
        moto2.setMake("Suzuki");
        moto2.setModel("DR650");
        moto2.setYear("2012");
        moto2.setColor("gray");

        moto2 = motoInventoryRepository.save(moto2);

        List<Motorcycle> motoList = motoInventoryRepository.findAll();

        assertEquals(motoList.size(), 2);
    }

    @Test
    public void getMotorcyclesByMake() {
        Motorcycle moto = new Motorcycle();
        moto.setVin("22222");
        moto.setMake("Honda");
        moto.setModel("CB300");
        moto.setYear("2019");
        moto.setColor("red");

        motoInventoryRepository.save(moto);

        moto = new Motorcycle();
        moto.setVin("33333");
        moto.setMake("Suzuki");
        moto.setModel("DR650");
        moto.setYear("2012");
        moto.setColor("gray");

        motoInventoryRepository.save(moto);

        moto = new Motorcycle();
        moto.setVin("44444");
        moto.setMake("Suzuki");
        moto.setModel("DRZ 400");
        moto.setYear("2016");
        moto.setColor("black");

        motoInventoryRepository.save(moto);

        moto = new Motorcycle();
        moto.setVin("55555");
        moto.setMake("Ducati");
        moto.setModel("DRZ 400");
        moto.setYear("2016");
        moto.setColor("black");

        motoInventoryRepository.save(moto);

        List<Motorcycle> mList = motoInventoryRepository.findByMake("Suzuki");
        assertEquals(2, mList.size());

        mList = motoInventoryRepository.findByMake("Honda");
        assertEquals(1, mList.size());

        mList = motoInventoryRepository.findByMake("Ducati");
        assertEquals(1, mList.size());

    }


    @Test
    public void updateMotorcycle() {

        Motorcycle moto = new Motorcycle();
        moto.setVin("12345");
        moto.setMake("Honda");
        moto.setModel("Africa Twin");
        moto.setYear("2019");
        moto.setColor("black");

        moto = motoInventoryRepository.save(moto);

        moto.setVin("99999");
        moto.setMake("UPDATED");
        moto.setModel("NEW MODEL");
        moto.setYear("1111");
        moto.setColor("NEW COLOR");

        motoInventoryRepository.save(moto);

        Motorcycle moto2 = motoInventoryRepository.getOne(moto.getId());

        assertEquals(moto2, moto);
    }

}