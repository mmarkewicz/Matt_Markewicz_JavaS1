package com.company;

import java.util.Scanner;

public class MultiplyThree {

    // multiply three numbers inputted by user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Number: ");
        int firstNum = scanner.nextInt();

        System.out.println("Second Number: ");
        int secondNum = scanner.nextInt();

        System.out.println("Third Number: ");
        int thirdNum = scanner.nextInt();

        int solution = firstNum * secondNum * thirdNum;
        System.out.println("Solution: " + solution);
    }

}