package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Amount of Mortgage: ");
        int total = scanner.nextInt();

        System.out.println("Enter Term of Mortgage: ");
        int term = scanner.nextInt();

        System.out.println("Enter Annual Interest Rate of Mortgage");
        int annualInterestRate = scanner.nextInt();

    }
}
