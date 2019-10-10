package com.company;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private int miles;

    public Car(String make, String model, int year, String color, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getMiles() {
        return miles;
    }
}
