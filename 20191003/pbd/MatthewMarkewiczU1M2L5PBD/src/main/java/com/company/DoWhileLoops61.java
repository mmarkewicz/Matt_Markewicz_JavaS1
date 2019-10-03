package com.company;

import java.util.Scanner;

public class DoWhileLoops61 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isComplete = false;
        int currentSide = 1;
        int sideOne = 0;
        int sideTwo = 0;
        int sideThree = 0;

        System.out.println("Enter three integers: ");

        do {
            if (currentSide == 1) {
                System.out.println("Side 1: ");
                int userInput = scanner.nextInt();
                sideOne = userInput;
                currentSide++;
            } else if (currentSide == 2) {
                System.out.println("Side 2: ");
                int userInput = scanner.nextInt();
                if (userInput >= sideOne) {
                    sideTwo = userInput;
                    currentSide++;
                } else {
                    System.out.println(userInput + " is less than " + sideOne + ". Try again!");
                }
            } else if (currentSide == 3) {
                System.out.println("Side 3: ");
                int userInput = scanner.nextInt();
                if (userInput >= sideTwo) {
                    sideThree = userInput;
                    currentSide++;
                } else {
                    System.out.println(userInput + " is less than " + sideTwo + ". Try again!");
                }
            } else if (currentSide == 4) {
                if ((sideOne * sideOne + sideTwo * sideTwo) == (sideThree * sideThree)) {
                    System.out.println("These sides *do* make a right triangle! Yippy-skippy!");
                    isComplete = true;
                } else {
                    System.out.println("NO! These sides do not make a right triangle");
                    isComplete = true;
                }
            }
        } while(!isComplete);
}

}
