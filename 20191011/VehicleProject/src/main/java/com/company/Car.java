package com.company;

public class Car {
    private static int counter = 0;

    Car() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Car.counter = counter;
    }
}
