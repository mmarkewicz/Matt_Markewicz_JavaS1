package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Amount of Mortgage: ");
        double L = scanner.nextDouble();

        System.out.println("Enter Term of Mortgage: ");
        int n = scanner.nextInt();

        System.out.println("Enter Annual Interest Rate of Mortgage");
        double interest = scanner.nextFloat() / 100d;

        double c =  interest / 12.0000d;

        // P = L[c(1 + c)^n]/[(1 + c)^n - 1]
        // P = Fixed Monthly Payment, L = Total Dollars, n = number of months, c = monthly interest rate
        double onePlusC = 1.00d + c;

        double numeratorExp = (double) Math.pow(onePlusC, n);
        double numeratorExpTimesC = numeratorExp * c;
        double numerator = L * numeratorExpTimesC;
        double denominatorExp = (double) Math.pow((onePlusC), n);
        double denominator = denominatorExp - 1;
        double total = numerator / denominator;

        System.out.println("Calculated Monthly Payment: " + total);
    }
}
