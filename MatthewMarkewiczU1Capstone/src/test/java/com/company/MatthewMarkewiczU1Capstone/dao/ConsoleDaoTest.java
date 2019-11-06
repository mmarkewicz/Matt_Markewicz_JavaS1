package com.company.MatthewMarkewiczU1Capstone.dao;

import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsoleDaoTest {

    @Autowired
    ConsoleDao consoleDao;

    @Before
    public void setUp() {
        // read all consoles from test database and delete entries before test
        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream()
                .forEach(console -> consoleDao.deleteConsole(console.getConsoleId()));
    }

    @After
    public void tearDown() {
        // read all consoles from test database and delete entries after test
        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.stream()
                .forEach(console -> consoleDao.deleteConsole(console.getConsoleId()));
    }

    @Test
    public void addGetDeleteConsole() {
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setQuantity(10);
        console.setProcessor("Test Processor");
        console.setPrice(new BigDecimal(299.99));
        console.setMemoryAmount("100");
        console.setManufacturer("Sony");
        console = consoleDao.addConsole(console); // save database entry of console
        console.setPrice(console.getPrice().setScale(2, RoundingMode.HALF_EVEN)); // trim trailing 0s in BigDecimal from database

        Console testConsole = consoleDao.getConsole(console.getConsoleId());
        assertEquals(console, testConsole);

        consoleDao.deleteConsole(console.getConsoleId());
        assertEquals(consoleDao.getAllConsoles().size(), 0); // assert that delete DAO method works by checking that an entry has been removed from the database
    }

    @Test
    public void updateConsole() {
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setQuantity(10);
        console.setProcessor("Test Processor");
        console.setPrice(new BigDecimal(299.99));
        console.setMemoryAmount("100");
        console.setManufacturer("Sony");
        console = consoleDao.addConsole(console); // save database entry of console
        console.setPrice(console.getPrice().setScale(2, RoundingMode.HALF_EVEN)); // trim trailing 0s in BigDecimal from database

        console.setManufacturer("Not Sony");
        consoleDao.updateConsole(console);

        assertEquals(consoleDao.getConsole(console.getConsoleId()).getManufacturer(), "Not Sony");
    }

    @Test
    public void getAllConsoles() {
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setQuantity(10);
        console.setProcessor("Test Processor");
        console.setPrice(new BigDecimal(299.99));
        console.setMemoryAmount("100");
        console.setManufacturer("Sony");
        console = consoleDao.addConsole(console); // save database entry of console
        console.setPrice(console.getPrice().setScale(2, RoundingMode.HALF_EVEN)); // trim trailing 0s in BigDecimal from database

        Console console2 = new Console();
        console2.setModel("PlayStation 4");
        console2.setQuantity(10);
        console2.setProcessor("Test Processor");
        console2.setPrice(new BigDecimal(299.99));
        console2.setMemoryAmount("100");
        console2.setManufacturer("Sony");
        console2 = consoleDao.addConsole(console2); // save database entry of console
        console2.setPrice(console2.getPrice().setScale(2, RoundingMode.HALF_EVEN)); // trim trailing 0s in BigDecimal from database

        assertEquals(consoleDao.getAllConsoles().size(), 2);
    }

    @Test
    public void getConsolesByManufacturer() {
        Console console = new Console();
        console.setModel("PlayStation 4");
        console.setQuantity(10);
        console.setProcessor("Test Processor");
        console.setPrice(new BigDecimal(299.99));
        console.setMemoryAmount("100");
        console.setManufacturer("Sony");
        consoleDao.addConsole(console); // save database entry of console

        List<Console> consoleList = consoleDao.getConsolesByManufacturer("Sony");

        assertEquals(consoleList.get(0).getManufacturer(), "Sony");
    }
}
