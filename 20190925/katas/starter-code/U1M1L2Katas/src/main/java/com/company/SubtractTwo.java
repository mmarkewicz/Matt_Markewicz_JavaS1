package com.company;

import java.util.Scanner;

public class SubtractTwo {

    // subtract the second number from the first number inputted by the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Number: ");
        int numOne = scanner.nextInt();

        System.out.println("Second Number: ");
        int numTwo = scanner.nextInt();

        int result = numOne - numTwo;
        System.out.println("Result: " + result);
    }
}
