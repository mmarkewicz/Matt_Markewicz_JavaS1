package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        // prompt user to enter the salary for player 1, player 2, and player 3 (without $ or commas)
        // calculate and display total salary for all 3 people
        // if team went over spending limit, calculate and display cost of luxury tax
        // spending limit is $40million
        // lux tax rate is 18%, and is only paid on the amount of salary over the team's spending limit
        // ex: if team payroll is $55million, they only pay 18% of the $15million they are over the cap, not the entire salary

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Player 1's Salary: ");
        int playerOneSal = scanner.nextInt();

        System.out.println("Enter Player 2's Salary: ");
        int playerTwoSal = scanner.nextInt();

        System.out.println("Enter Player 3's Salary: ");
        int playerThreeSal = scanner.nextInt();

        int totalSalary = playerOneSal + playerTwoSal + playerThreeSal;
        System.out.println("Total Salary: " + totalSalary);

        if (totalSalary > 45000000) {
            int taxableTotal = totalSalary - 45000000;
            System.out.println("Taxable Total: " + taxableTotal);
            float totalTax = 0.24f * taxableTotal;
            System.out.println("Total Tax Owed: " + totalTax);
        } else {
            System.out.println("There is no luxury tax");
        }

    }
}
