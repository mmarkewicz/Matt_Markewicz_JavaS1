package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    public static void initialPrompt(Inventory inventory) {
        String userMenuSelection = scanner.nextLine().toLowerCase();
        switch (userMenuSelection) {
            case "a":
            case "1":
                displayAddPrompt(inventory);
                break;
            case "r":
            case "2":
                displayRemovePrompt(inventory);
                break;
            case "s":
            case "3":
                inventory.showAll();
                break;
            case "d":
            case "4":
                displaySearchPrompt(inventory);
                break;
            default:
                System.out.println("Please enter a valid input");
                initialPrompt(inventory);
        }
    }

    public static void displayAddPrompt(Inventory inventory) {
        System.out.println("Please answer some questions about the car you wish to add.");
        System.out.println("What is the make of the car?");
        String userMake = scanner.next();
        System.out.println("What is the model of the car?");
        String userModel = scanner.next();
        System.out.println("What is the year of the car?");
        int userYear = scanner.nextInt();
        System.out.println("What is the color of the car?");
        String userColor = scanner.next();
        System.out.println("How many miles are on the car?");
        int userMiles = scanner.nextInt();
        Car userCar = new Car(userMake, userModel, userYear, userColor, userMiles);
        inventory.add(userCar);
        System.out.println("You have successfully added the car to the inventory!");
    }

    public static void displayRemovePrompt(Inventory inventory) {
        System.out.println("Enter the ID of the car you wish to remove.");
        inventory.showAll();
        int userID = scanner.nextInt();
        inventory.delete(userID);
        inventory.showAll();
    }

    public static void displaySearchPrompt(Inventory inventory) {
        System.out.println("What category would you like to search by?");
        System.out.println("Options: make, model, year, miles, color");
        String userCategory = scanner.next().toLowerCase();
        switch (userCategory) {
            case "make":
                System.out.println("Enter the make of the car: ");
                String make = scanner.next();
                inventory.searchMake(make);
                break;
            case "model":
                System.out.println("Enter the model of the car: ");
                String model = scanner.next();
                inventory.searchModel(model);
                break;
            case "year":
                System.out.println("Which year would you like to search for?");
                int year = scanner.nextInt();
                inventory.searchYear(year);
                break;
            case "color":
                System.out.println("Enter the color of the car: ");
                String color = scanner.next().trim();
                inventory.searchColor(color);
                break;
            case "miles":
                System.out.println("Enter the maximum number of miles for the car: ");
                int miles = scanner.nextInt();
                inventory.searchMiles(miles);
                break;
            default:
                System.out.println("Please choose a valid input");
                displaySearchPrompt(inventory);
                break;
        }
    }

    // MAIN -----------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Car carOne = new Car("Toyota", "Camry", 1999, "Black", 100000);
        Car carTwo = new Car("Honda", "Accord", 2010, "Tan", 50000);
        Car carThree = new Car("Toyota", "Highlander", 1999, "Black", 100000);

        inventory.initialCars(carOne, carTwo, carThree);

        System.out.println("Welcome to the Vehicle Inventory!");
        System.out.println(" ");
        System.out.println("Choose one of the following services:");
        System.out.println("1. [A]dd a car to the inventory");
        System.out.println("2. [R]emove a car from the inventory");
        System.out.println("3. [D]isplay all cars in the inventory");
        System.out.println("4. [S]earch for a specific car");

        initialPrompt(inventory);
    }
}