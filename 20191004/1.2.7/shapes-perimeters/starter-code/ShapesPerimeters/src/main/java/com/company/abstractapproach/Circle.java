package com.company.abstractapproach;

public class Circle extends Shape {

    private double radius;
    private double pi = 3.1415;

    @Override
    public double area() {
        double area = (radius * radius) * pi;
        return area;
    }

    @Override
    public double perimeter() {
        double circumference = 2 * pi * radius;
        return circumference;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }
}
