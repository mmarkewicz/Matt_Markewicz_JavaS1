package com.company;

import java.util.Random;

public class ForLoops75 {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("Baby Blackjack!");

        int dealerOne = rand.nextInt(10) + 1;
        int dealerTwo = rand.nextInt(10) + 1;
        int dealerTotal = dealerOne + dealerTwo;
        int playerOne = rand.nextInt(10) + 1;
        int playerTwo = rand.nextInt(10) + 1;
        int playerTotal = playerOne + playerTwo;

        System.out.println(" ");
        System.out.println("You drew " + playerOne + " and " + playerTwo + ".");
        System.out.println("Your total is " + playerTotal);
        System.out.println(" ");
        System.out.println("The dealer drew " + dealerOne + " and " + dealerTwo + ".");
        System.out.println("The dealer's total is " + dealerTotal);
        System.out.println(" ");

        if (dealerTotal == playerTotal) {
            System.out.println("PUSH!");
        } else if (dealerTotal > playerTotal) {
            System.out.println("DEALER WINS!");
        } else {
            System.out.println("YOU WIN!");
        }

    }
}
