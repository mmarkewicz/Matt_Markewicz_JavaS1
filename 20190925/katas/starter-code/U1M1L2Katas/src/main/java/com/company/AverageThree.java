package com.company;

import java.util.Scanner;

public class AverageThree {

    // find the avg of three numbers inputted by the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number One: ");
        double num1 = scanner.nextDouble();
        System.out.println("Number Two: ");
        double num2 = scanner.nextDouble();
        System.out.println("Number Three: ");
        double num3 = scanner.nextDouble();

        double result = (num1 + num2 + num3) / 3.00;
        System.out.println("Result: " + result);
    }
}
