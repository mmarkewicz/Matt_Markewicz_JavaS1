package com.company;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    Inventory inventory;
    Car carOne;
    Car carTwo;
    Car carThree;
    Car carFour;

    @Before
    public void setUp() {
        inventory = new Inventory();
        carOne = new Car("Toyota", "Camry", 1999, "Black", 100000);
        carTwo = new Car("Honda", "Accord", 2010, "Tan", 50000);
        carThree = new Car("Toyota", "Highlander", 1999, "Black", 100000);
        carFour = new Car("Custom Car", "Test", 2019, "Red", 100);
        inventory.initialCars(carOne, carTwo, carThree);
    }

    @Test
    public void shouldListGetBiggerAfterAdd() {
        assertSame(inventory.getInventoryList().size(), 3);
        inventory.add(carFour);
        assertSame(inventory.getInventoryList().size(), 4);
    }

    @Test
    public void shouldListGetSmallerAfterRemove() {
        inventory.delete(1);
        assertSame(inventory.getInventoryList().size(), 2);
        inventory.delete(1);
        assertSame(inventory.getInventoryList().size(), 1);
    }

}
