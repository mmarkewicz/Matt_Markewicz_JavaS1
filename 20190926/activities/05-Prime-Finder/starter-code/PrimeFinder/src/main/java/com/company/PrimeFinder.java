package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        // take in user input as ceiling (inclusive) and print all prime numbers from 1 to the input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        // ex: 10
        int userInput = scanner.nextInt();

        // iterate through each number before userInput
        for (int i = 2; i <= userInput; i++) {
            boolean isPrime = true;
            // test current number for primeness
            for (int j = 2; j < i; j++) {
                // if number divided by iterator leaves remainder of 0, number is not prime
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }

        }
    }
}
