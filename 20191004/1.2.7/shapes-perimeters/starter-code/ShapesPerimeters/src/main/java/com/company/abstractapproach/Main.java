package com.company.abstractapproach;

public class Main {
    public static void main(String[] args) {

        Square square = new Square();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        System.out.println("-----------------------------------------------------------------");

        square.setSide(5);
        System.out.println("The area of the square is " + square.area());
        System.out.println("The perimeter of the square is " + square.perimeter());

        System.out.println("-----------------------------------------------------------------");

        circle.setRadius(5.0);
        System.out.println("The area of the circle is " + circle.area());
        System.out.println("The perimeter of the circle is " + circle.perimeter());

        System.out.println("-----------------------------------------------------------------");

        triangle.setSideA(5);
        triangle.setSideB(10);
        triangle.setSideC(20);
        triangle.setHeight(20);
        triangle.setWidth(15);
        System.out.println("The area of the triangle is " + triangle.area());
        System.out.println("The perimeter of the triangle is " + triangle.perimeter());

        System.out.println("-----------------------------------------------------------------");


    }
}
