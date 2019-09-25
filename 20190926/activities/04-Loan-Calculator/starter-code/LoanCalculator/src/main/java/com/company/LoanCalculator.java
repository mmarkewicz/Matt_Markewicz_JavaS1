package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Amount of Mortgage: ");
        float L = scanner.nextFloat();

        System.out.println("Enter Term of Mortgage: ");
        int n = scanner.nextInt();

        System.out.println("Enter Annual Interest Rate of Mortgage");
        float interest = scanner.nextFloat() / 100;

        float c =  interest / 12.0000f;

        // P = L[c(1 + c)^n]/[(1 + c)^n - 1]
        // P = Fixed Monthly Payment, L = Total Dollars, n = number of months, c = monthly interest rate
        float onePlusC = 1.00f + c;

        float numeratorExp = (float) Math.pow(onePlusC, n);
        float numeratorExpTimesC = numeratorExp * c;
        float numerator = L * numeratorExpTimesC;
        float denominatorExp = (float) Math.pow((onePlusC), n);
        float denominator = denominatorExp - 1;
        float total = numerator / denominator;

        System.out.println("Calculated Monthly Payment: " + total);
    }
}
