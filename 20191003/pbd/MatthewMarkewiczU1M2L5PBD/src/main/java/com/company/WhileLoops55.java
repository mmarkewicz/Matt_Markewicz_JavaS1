package com.company;

import java.util.Scanner;

public class WhileLoops55 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean didUserPick0 = false;
        int total = 0;

        System.out.println("I will add up the numbers you give me.");

        while (!didUserPick0) {
            System.out.println("Number: ");
            int userInt = scanner.nextInt();

            if (userInt == 0) {
                didUserPick0 = true;
                System.out.println("The total is " + total);
            } else {
                total += userInt;
                System.out.println("The total so far is " + total);
            }

        }
    }

}
