package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userInputCount = 0;
        int[] userArray = new int[5];

        while (userInputCount < 5) {
            System.out.println("Enter an integer: ");
            int userInput = scanner.nextInt();

            userArray[userInputCount] = userInput;
            userInputCount++;
        }

        for (int element : userArray) {
            System.out.println(element);
        }
    }

}
