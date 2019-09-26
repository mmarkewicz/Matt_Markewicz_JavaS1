package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: "); // terminal prompt
        int userInput = scanner.nextInt(); // save user input

        // iterate through each number before userInput
        for (int i = 2; i <= userInput; i++) {

            boolean isPrime = true; // set each integer to prime initially

            // test current number for primeness
            for (int j = 2; j < i; j++) {
                // if number divided by iterator leaves remainder of 0, number is not prime
                if (i % j == 0) {
                    isPrime = false;
                }
            }

            // if the isPrime bool is true, print the current value of i
            if (isPrime) {
                System.out.println(i);
            }

        }
    }
}
