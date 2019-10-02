package com.company;

import java.util.Scanner;

public class DoWhileLoops60 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isInputNegative = true;

        System.out.println("Enter a number: ");

        do {
            int userInt = scanner.nextInt();

            if (userInt < 0) {
                System.out.println("You can't take the square root of a negative number, silly.");
                System.out.println("Try again: ");
            } else {
                System.out.println("The square root of " + userInt + " is " + Math.sqrt(userInt) + ".");
                isInputNegative = false;
            }

        } while(isInputNegative);
    }

}
