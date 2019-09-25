package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isGuess42 = false;

        while(!isGuess42) {
            System.out.println("Enter a number between 1 and 100");
            int userInt = scanner.nextInt();

            if (userInt == 42) {
                System.out.println("That's the number I was looking for! 42 is definitely the answer!");
                isGuess42 = true;
            }
        }




    }
}
