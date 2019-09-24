package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    // add 5 to the number inputted by the user, then double it
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input Number: ");
        int num = scanner.nextInt();

        int total = 2 * (num + 5);
        System.out.println("Result: " + total);

    }
}
