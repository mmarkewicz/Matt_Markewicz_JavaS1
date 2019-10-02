package com.company;

import java.util.Random;
import java.util.Scanner;

public class RandomNumbers47 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randomIndex = rand.nextInt(3) + 1; // random int from 1-3

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.");
        System.out.println("He glances at you out of the corner of his eye and starts shuffling.");
        System.out.println("He lays down three cards.");
        System.out.println(" ");
        System.out.println("Which one is the ace?");
        System.out.println(" ");
        System.out.println("     ##  ##  ##");
        System.out.println("     ##  ##  ##");
        System.out.println("     1   2   3 ");
        System.out.println(" ");

        int userInput = scanner.nextInt();

        if (userInput == randomIndex) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.");
            if (userInput == 1) {
                System.out.println("     AA  ##  ##");
                System.out.println("     AA  ##  ##");
                System.out.println("     1   2   3 ");
            } else if (userInput == 2) {
                System.out.println("     ##  AA  ##");
                System.out.println("     ##  AA  ##");
                System.out.println("     1   2   3 ");
            } else {
                System.out.println("     ##  ##  AA");
                System.out.println("     ##  ##  AA");
                System.out.println("     1   2   3 ");
            }
        } else {
            System.out.println("Ha! Fast Eddie wins again! The ace was card number " + randomIndex + ".");
            if (randomIndex == 1) {
                System.out.println("     AA  ##  ##");
                System.out.println("     AA  ##  ##");
                System.out.println("     1   2   3 ");
            } else if (randomIndex == 2) {
                System.out.println("     ##  AA  ##");
                System.out.println("     ##  AA  ##");
                System.out.println("     1   2   3 ");
            } else {
                System.out.println("     ##  ##  AA");
                System.out.println("     ##  ##  AA");
                System.out.println("     1   2   3 ");
            }
        }


    }

}
