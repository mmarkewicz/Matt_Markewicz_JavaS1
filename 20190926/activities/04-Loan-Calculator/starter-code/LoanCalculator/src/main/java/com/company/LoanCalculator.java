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
        float interest = scanner.nextFloat();

        float c =  interest / 12;

        // P = L[c(1 + c)n]/[(1 + c)n - 1]
        // P = Fixed Monthly Payment, L = Total Dollars, n = number of months, c = monthly interest rate
        float onePlusC = 1.00f + c;

        float numerator = c * onePlusC * n;
        float denominator = onePlusC * n;
        float dividedMinusOne = (numerator / denominator) - 1;
        float calculated = L * dividedMinusOne;

        System.out.println("Calculated Monthly Payment: " + calculated);

    }
}
