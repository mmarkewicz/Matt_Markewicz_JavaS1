package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isJava = false;

        while(!isJava) {
            System.out.println("What is your favorite programming language?");
            String userInput = scanner.next();

            if (userInput.equals("Java")) {
                isJava = true;
                System.out.println("That's what I was looking for! Java is definitely the answer!");
            }
        }

    }
}
