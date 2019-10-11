package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    // initialize new list
    private ArrayList<Car> inventoryList = new ArrayList<>();

    public void initialCars(Car carOne, Car carTwo, Car carThree) {
        inventoryList.add(carOne);
        inventoryList.add(carTwo);
        inventoryList.add(carThree);
    }

    public void add(Car car) {
        inventoryList.add(car);
    }

    public void delete(int index) {
        inventoryList.remove(index-1);
        System.out.println("Successfully removed a car from the inventory.");
    }

    public void showAll() {
        System.out.println("--------------- Inventory ---------------");
        inventoryList.stream()
                .forEach(car -> {
                    System.out.println(inventoryList.indexOf(car) + 1 + ". " + car.getYear() + " " + car.getColor() + " " + car.getMake() + " " + car.getModel() + " with " + car.getMiles() + " miles");
                });
    }

    public void searchMake(String make) {
        System.out.println("Searching for " + make + "s");
        inventoryList.stream()
                .filter(car -> car.getMake() == make)
                .forEach(car -> {
                    System.out.println(inventoryList.indexOf(car) + 1 + ". " + car.getYear() + " " + car.getColor() + " " + car.getMake() + " " + car.getModel() + " with " + car.getMiles() + " miles");
                });
    }

    public void searchModel(String model) {
        System.out.println("Searching for " + model + "s");
        inventoryList.stream()
                .filter(car -> car.getModel() == model)
                .forEach(car -> {
                    System.out.println(inventoryList.indexOf(car) + 1 + ". " + car.getYear() + " " + car.getColor() + " " + car.getMake() + " " + car.getModel() + " with " + car.getMiles() + " miles");
                });
    }

    public void searchYear(int year) {
        System.out.println("Searching for cars from " + year);
        inventoryList.stream()
                .filter(car -> car.getYear() == year)
                .forEach(car -> {
                    System.out.println(inventoryList.indexOf(car) + 1 + ". " + car.getYear() + " " + car.getColor() + " " + car.getMake() + " " + car.getModel() + " with " + car.getMiles() + " miles");
                });
    }

    public void searchColor(String color) {
        System.out.println("Searching for " + color + " cars");
        inventoryList.stream()
                .filter(car -> car.getColor() == color)
                .forEach(car -> {
                    System.out.println(inventoryList.indexOf(car) + 1 + ". " + car.getYear() + " " + car.getColor() + " " + car.getMake() + " " + car.getModel() + " with " + car.getMiles() + " miles");
                });
    }

    public void searchMiles(int miles) {
        System.out.println("Searching for cars under  " + miles + " miles");
        inventoryList.stream()
                .filter(car -> car.getMiles() <= miles)
                .forEach(car -> {
                    System.out.println(inventoryList.indexOf(car) + 1 + ". " + car.getYear() + " " + car.getColor() + " " + car.getMake() + " " + car.getModel() + " with " + car.getMiles() + " miles");
                });
    }

    // inventoryList getter
    public List<Car> getInventoryList() {
        return inventoryList;
    }

}
