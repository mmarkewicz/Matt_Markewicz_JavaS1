package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // random number generator
        Random rand = new Random();
        int low = 1;
        int high = 101;
        int result = rand.nextInt(high-low) + low;

        // console instructions
        System.out.println("Welcome to Hi-Low!");
        System.out.println("Enter Username: ");
        String username = scanner.next();

        System.out.println("OK, " + username + ", here are the rules:");

        boolean isUserCorrect = false;
        int numGuesses = 0;

        while(!isUserCorrect) {
            System.out.println("Pick a number between 1 and 100");
            int userSelection = scanner.nextInt();

            if (userSelection == result) {
                System.out.println("Congratulations, " + username + "! You win!");
                numGuesses++;
                System.out.println("It took you " + numGuesses + " guesses to find my number!");
                isUserCorrect = true;
            } else if (userSelection > result) {
                System.out.println("Too high");
                numGuesses++;
            } else if (userSelection < result) {
                System.out.println("Too low");
                numGuesses++;
            }
        }

    }
}
