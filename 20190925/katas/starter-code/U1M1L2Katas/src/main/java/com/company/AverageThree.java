package com.company;

import java.util.Scanner;

public class AverageThree {

    // find the avg of three numbers inputted by the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Number One: ");
        float num1 = scanner.nextFloat();
        System.out.println("Number Two: ");
        float num2 = scanner.nextFloat();
        System.out.println("Number Three: ");
        float num3 = scanner.nextFloat();

        float result = (num1 + num2 + num3) / 3.00f;
        System.out.println("Result: " + result);
    }
}
