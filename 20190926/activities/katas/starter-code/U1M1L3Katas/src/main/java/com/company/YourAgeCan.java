package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userAge = scanner.nextInt();

        String canVote = "Vote (18+)";
        String canDrink = "Drink alcohol (21+)";
        String canBePresident = "Be president (35+)";
        String canGetAARP = "Is eligible for AARP (55+)";
        String canRetire = "Can retire (55+)";
        String isOcto = "Is an octogenerian (80-89)";
        String isCent = "Is more than a century old (100+)";

        if (userAge < 18) {
            System.out.println("Too young to qualify for anything");
        }
        if (userAge >= 18) {
            System.out.println(canVote);
        }
        if (userAge >= 21) {
            System.out.println(canDrink);
        }
        if (userAge >= 35) {
            System.out.println(canBePresident);
        }
        if (userAge >= 55) {
            System.out.println(canGetAARP);
        }
        if (userAge >= 65) {
            System.out.println(canRetire);
        }
        if (userAge >= 80 && userAge <= 89) {
            System.out.println(isOcto);
        }
        if (userAge >= 100) {
            System.out.println(isCent);
        }

    }
}
