package com.company;

import java.util.Scanner;

public class ValidNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isInputValid = false;

        while (!isInputValid) {
            System.out.println("Enter a number between 1 and 10");
            int userInput = scanner.nextInt();
            if (userInput > 10 || userInput < 1) {
                System.out.println("You must enter a number between 1 and 10, please try again.");
            } else {
                System.out.println(userInput);
                isInputValid = true;
            }
        }
    }

}
