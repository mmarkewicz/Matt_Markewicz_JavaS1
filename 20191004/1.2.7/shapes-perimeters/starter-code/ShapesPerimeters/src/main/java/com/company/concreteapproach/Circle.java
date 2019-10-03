package com.company.concreteapproach;

public class Circle extends Shape {
    private double radius;
    private String name;
    private String color;
    private float xCoordinate;
    private float yCoordinate;

    @Override
    public void area() {
        double area = (radius * radius) * 3.1415;
        System.out.println("The area of the circle is " + area);
    }

    @Override
    public void perimeter() {
        double circumference = 2 * 3.1415 * radius;
        System.out.println("The circumference of the circle is " + circumference);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
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

    public float getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(float xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public float getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(float yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
