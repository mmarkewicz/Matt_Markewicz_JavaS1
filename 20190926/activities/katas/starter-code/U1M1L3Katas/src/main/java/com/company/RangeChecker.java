package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // ask user for a number between 15 and 32 (not inclusive)
        // continue to prompt user until they provide a number in the range
        // once they do, output valid number to console

        boolean isInRange = false;

        while (!isInRange) {
            System.out.println("Enter a number between 15 and 32");
            int userSelection = scanner.nextInt();

            if (userSelection < 32 && userSelection > 15) {
                System.out.println("You chose " + userSelection + " which is in the range!");
                isInRange = true;
            }

        }
    }
}
