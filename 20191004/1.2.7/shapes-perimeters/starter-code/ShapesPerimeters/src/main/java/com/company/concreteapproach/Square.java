package com.company.concreteapproach;

public class Square extends Shape {
    private String name;
    private String color;
    private double xCoordinate;
    private double yCoordinate;
    private double sideLength;

    @Override
    public void area() {
        double area = sideLength * sideLength;
        System.out.println("The area of the square is " + area);
    }

    @Override
    public void perimeter() {
        double perimeter = 4 * sideLength;
        System.out.println("The perimeter of the square is " + perimeter);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}
