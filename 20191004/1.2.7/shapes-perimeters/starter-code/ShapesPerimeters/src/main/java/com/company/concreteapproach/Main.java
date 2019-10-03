package com.company.concreteapproach;

public class Main {
    public static void main(String[] args) {
        Square square = new Square();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        System.out.println("-----------------------------------------------------------------");

        // check Square class
        square.setSideLength(5);
        square.area();
        square.perimeter();

        System.out.println("-----------------------------------------------------------------");

        // check Circle class
        circle.setRadius(10);
        circle.area();
        circle.perimeter();

        System.out.println("-----------------------------------------------------------------");

        // check Triangle class
        triangle.setHeight(10);
        triangle.setWidth(5);
        triangle.setSideA(10);
        triangle.setSideB(5);
        triangle.setSideC(8);
        triangle.area();
        triangle.perimeter();

        System.out.println("-----------------------------------------------------------------");
    }
}
