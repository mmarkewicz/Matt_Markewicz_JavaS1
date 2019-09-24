package com.company;

import java.util.Scanner;

public class AddThirteen {

    // add 13 to the variable inputted by the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = scanner.nextInt();

        int result = number + 13;
        System.out.println("Result: " + result);

    }
}
