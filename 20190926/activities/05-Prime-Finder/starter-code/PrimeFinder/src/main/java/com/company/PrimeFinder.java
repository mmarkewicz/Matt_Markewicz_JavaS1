package com.company;

import java.util.Scanner;

public class PrimeFinder {

    public static void checkIfPrimeAndPrint(int num) {
        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
            }
        }
        if (isPrime) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: "); // terminal prompt
        int userInput = scanner.nextInt(); // save user input

        // iterate through each number before userInput
        for (int i = 2; i <= userInput; i++) {
            PrimeFinder.checkIfPrimeAndPrint(i);
        }
    }
}
