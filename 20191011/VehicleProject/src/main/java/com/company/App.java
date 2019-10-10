package com.company;

public class App {
    public static void main(String[] args) {
        Car one = new Car();
        Car two = new Car();

        System.out.println(two.getCounter());
        System.out.println(one.getCounter());
    }
}
