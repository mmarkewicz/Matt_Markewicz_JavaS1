package com.company.MatthewMarkewiczU1Capstone.service;

import com.company.MatthewMarkewiczU1Capstone.dao.ConsoleDao;
import com.company.MatthewMarkewiczU1Capstone.dto.Console;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleServiceTest {

    ConsoleService consoleService;

    @Mock
    ConsoleDao consoleDao;

    @Before
    public void setUp() {
        setUpConsoleMocks();

        consoleService = new ConsoleService(consoleDao);
    }

    @Test
    public void shouldAddNewConsoleFromServiceLayer() {
        Console consoleOne = new Console();
        consoleOne.setManufacturer("Sony");
        consoleOne.setPrice(new BigDecimal(299.99));
        consoleOne.setMemoryAmount("500GB");
        consoleOne.setProcessor("120GHz");
        consoleOne.setQuantity(100);
        consoleOne.setModel("Playstation 4");

        Console consoleTwo = new Console();
        consoleTwo.setManufacturer("Microsoft");
        consoleTwo.setPrice(new BigDecimal(269.99));
        consoleTwo.setMemoryAmount("400GB");
        consoleTwo.setProcessor("110GHz");
        consoleTwo.setQuantity(80);
        consoleTwo.setModel("Xbox One");

        Console consoleOneFromDb = new Console();
        consoleOneFromDb.setManufacturer("Sony");
        consoleOneFromDb.setPrice(new BigDecimal(299.99));
        consoleOneFromDb.setMemoryAmount("500GB");
        consoleOneFromDb.setProcessor("120GHz");
        consoleOneFromDb.setQuantity(100);
        consoleOneFromDb.setModel("Playstation 4");
        consoleOneFromDb.setConsoleId(340);

        Console consoleTwoFromDb = new Console();
        consoleTwoFromDb.setManufacturer("Microsoft");
        consoleTwoFromDb.setPrice(new BigDecimal(269.99));
        consoleTwoFromDb.setMemoryAmount("400GB");
        consoleTwoFromDb.setProcessor("110GHz");
        consoleTwoFromDb.setQuantity(80);
        consoleTwoFromDb.setModel("Xbox One");
        consoleTwoFromDb.setConsoleId(645);

        assertEquals(consoleOneFromDb, consoleService.saveConsole(consoleOne));
        assertEquals(consoleTwoFromDb, consoleService.saveConsole(consoleTwo));
    }

    @Test
    public void shouldReturnConsoleFromServiceLayer() {
        Console consoleOneFromDb = new Console();
        consoleOneFromDb.setManufacturer("Sony");
        consoleOneFromDb.setPrice(new BigDecimal(299.99));
        consoleOneFromDb.setMemoryAmount("500GB");
        consoleOneFromDb.setProcessor("120GHz");
        consoleOneFromDb.setQuantity(100);
        consoleOneFromDb.setModel("Playstation 4");
        consoleOneFromDb.setConsoleId(340);

        Console consoleTwoFromDb = new Console();
        consoleTwoFromDb.setManufacturer("Microsoft");
        consoleTwoFromDb.setPrice(new BigDecimal(269.99));
        consoleTwoFromDb.setMemoryAmount("400GB");
        consoleTwoFromDb.setProcessor("110GHz");
        consoleTwoFromDb.setQuantity(80);
        consoleTwoFromDb.setModel("Xbox One");
        consoleTwoFromDb.setConsoleId(645);

        assertEquals(consoleOneFromDb, consoleService.findConsole(340));
        assertEquals(consoleTwoFromDb, consoleService.findConsole(645));
    }

    @Test
    public void shouldReturnListOfAllConsolesInDb() {
        Console consoleOne = new Console();
        consoleOne.setManufacturer("Sony");
        consoleOne.setPrice(new BigDecimal(299.99));
        consoleOne.setMemoryAmount("500GB");
        consoleOne.setProcessor("120GHz");
        consoleOne.setQuantity(100);
        consoleOne.setModel("Playstation 4");

        Console consoleTwo = new Console();
        consoleTwo.setManufacturer("Microsoft");
        consoleTwo.setPrice(new BigDecimal(269.99));
        consoleTwo.setMemoryAmount("400GB");
        consoleTwo.setProcessor("110GHz");
        consoleTwo.setQuantity(80);
        consoleTwo.setModel("Xbox One");

        Console consoleOneFromDb = new Console();
        consoleOneFromDb.setManufacturer("Sony");
        consoleOneFromDb.setPrice(new BigDecimal(299.99));
        consoleOneFromDb.setMemoryAmount("500GB");
        consoleOneFromDb.setProcessor("120GHz");
        consoleOneFromDb.setQuantity(100);
        consoleOneFromDb.setModel("Playstation 4");
        consoleOneFromDb.setConsoleId(340);

        Console consoleTwoFromDb = new Console();
        consoleTwoFromDb.setManufacturer("Microsoft");
        consoleTwoFromDb.setPrice(new BigDecimal(269.99));
        consoleTwoFromDb.setMemoryAmount("400GB");
        consoleTwoFromDb.setProcessor("110GHz");
        consoleTwoFromDb.setQuantity(80);
        consoleTwoFromDb.setModel("Xbox One");
        consoleTwoFromDb.setConsoleId(645);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(consoleOneFromDb);
        consoleList.add(consoleTwoFromDb);

        assertEquals(consoleList, consoleService.findAllConsoles());
    }

    @Test
    public void shouldReturnListOfAllConsolesManufacturedBySony() {
        Console consoleOneFromDb = new Console();
        consoleOneFromDb.setManufacturer("Sony");
        consoleOneFromDb.setPrice(new BigDecimal(299.99));
        consoleOneFromDb.setMemoryAmount("500GB");
        consoleOneFromDb.setProcessor("120GHz");
        consoleOneFromDb.setQuantity(100);
        consoleOneFromDb.setModel("Playstation 4");
        consoleOneFromDb.setConsoleId(340);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(consoleOneFromDb);

        assertEquals(consoleList, consoleService.findConsolesByManufacturer("Sony"));
    }

    @Test
    public void shouldReturnNullWhenIdIsInvalid() {
        assertNull(consoleService.findConsole(1000000));
    }

    @Test
    public void shouldReturnEmptyListWhenInvalidManufacturer() {
        List<Console> consoleList = new ArrayList<>();
        assertEquals(consoleList, consoleService.findConsolesByManufacturer("Does Not Exist"));
    }

    public void setUpConsoleMocks() {
        Console consoleOne = new Console();
        consoleOne.setManufacturer("Sony");
        consoleOne.setPrice(new BigDecimal(299.99));
        consoleOne.setMemoryAmount("500GB");
        consoleOne.setProcessor("120GHz");
        consoleOne.setQuantity(100);
        consoleOne.setModel("Playstation 4");

        Console consoleTwo = new Console();
        consoleTwo.setManufacturer("Microsoft");
        consoleTwo.setPrice(new BigDecimal(269.99));
        consoleTwo.setMemoryAmount("400GB");
        consoleTwo.setProcessor("110GHz");
        consoleTwo.setQuantity(80);
        consoleTwo.setModel("Xbox One");

        Console consoleOneFromDb = new Console();
        consoleOneFromDb.setManufacturer("Sony");
        consoleOneFromDb.setPrice(new BigDecimal(299.99));
        consoleOneFromDb.setMemoryAmount("500GB");
        consoleOneFromDb.setProcessor("120GHz");
        consoleOneFromDb.setQuantity(100);
        consoleOneFromDb.setModel("Playstation 4");
        consoleOneFromDb.setConsoleId(340);

        Console consoleTwoFromDb = new Console();
        consoleTwoFromDb.setManufacturer("Microsoft");
        consoleTwoFromDb.setPrice(new BigDecimal(269.99));
        consoleTwoFromDb.setMemoryAmount("400GB");
        consoleTwoFromDb.setProcessor("110GHz");
        consoleTwoFromDb.setQuantity(80);
        consoleTwoFromDb.setModel("Xbox One");
        consoleTwoFromDb.setConsoleId(645);

        List<Console> consoleList = new ArrayList<>();
        consoleList.add(consoleOneFromDb);
        consoleList.add(consoleTwoFromDb);

        List<Console> consoleListOnlySony = new ArrayList<>();
        consoleListOnlySony.add(consoleOneFromDb);

        doReturn(consoleOneFromDb).when(consoleDao).addConsole(consoleOne);
        doReturn(consoleTwoFromDb).when(consoleDao).addConsole(consoleTwo);
        doReturn(consoleOneFromDb).when(consoleDao).getConsole(340);
        doReturn(consoleTwoFromDb).when(consoleDao).getConsole(645);
        doReturn(consoleList).when(consoleDao).getAllConsoles();
        doReturn(consoleListOnlySony).when(consoleDao).getConsolesByManufacturer("Sony");
    }

}
