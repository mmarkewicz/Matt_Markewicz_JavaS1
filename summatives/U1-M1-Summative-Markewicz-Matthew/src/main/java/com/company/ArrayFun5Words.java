package com.company;

import java.util.Scanner;

public class ArrayFun5Words {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInputIndex = 0;
        String[] userInputArr = new String[5];

        while (userInputIndex < 5) {
            System.out.println("Enter a String: ");
            String userInput = scanner.next();
            userInputArr[userInputIndex] = userInput;
            userInputIndex++;
        }

        for (String element : userInputArr) {
            System.out.println(element);
        }
    }

}
