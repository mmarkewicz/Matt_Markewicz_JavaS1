package com.company.concreteapproach;

public class Triangle extends Shape {
    private String name;
    private String color;
    private double xCoordinate;
    private double yCoordinate;
    private double height;
    private double width;
    private int sideA;
    private int sideB;
    private int sideC;

    @Override
    public void perimeter() {
        int perimeter = sideA + sideB + sideC;
        System.out.println("The perimeter of the triangle is " + perimeter);
    }

    @Override
    public void area() {
        double area = 1/2 * height * width;
        System.out.println("The area of the triangle is " + area);
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }
}
