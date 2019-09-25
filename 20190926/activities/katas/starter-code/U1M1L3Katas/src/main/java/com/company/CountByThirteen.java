package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int userSelection = scanner.nextInt();

        for (int i = 0; i <= userSelection; i = i + 13) {
            System.out.println(i);
        }
    }

}
