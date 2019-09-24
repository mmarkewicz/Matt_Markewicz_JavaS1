package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    // double number inputted by user, then add 5
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        int result = 2 * number + 5;
        System.out.println("Result: " + result);
    }
}
