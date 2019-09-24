package com.company;

import java.util.Scanner;

public class AddFive {

    // add 5 numbers inputted by the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Number: ");
        int num1 = scanner.nextInt();
        System.out.println("Second Number: ");
        int num2 = scanner.nextInt();
        System.out.println("Third Number: ");
        int num3 = scanner.nextInt();
        System.out.println("Fourth Number: ");
        int num4 = scanner.nextInt();
        System.out.println("Fifth Number: ");
        int num5 = scanner.nextInt();

        int result = num1 + num2 + num3 + num4 + num5;
        System.out.println("Result: " + result);
    }

}
