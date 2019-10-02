package com.company;

import java.util.Random;

public class DoWhileLoops58 {
    public static void main(String[] args) {
        Random rand = new Random();

        boolean isMatch = false;

        do {
            int diceOne = rand.nextInt(6) + 1; // 1 - 6
            int diceTwo = rand.nextInt(6) + 1; // 1 - 6
            int total = diceOne + diceTwo;

            System.out.println("Roll #1: " + diceOne);
            System.out.println("Roll #2: " + diceTwo);
            System.out.println("The total is " + total + "!");

            if (diceOne == diceTwo) {
                isMatch = true;
            }
        }
        while(!isMatch);
    }
}
