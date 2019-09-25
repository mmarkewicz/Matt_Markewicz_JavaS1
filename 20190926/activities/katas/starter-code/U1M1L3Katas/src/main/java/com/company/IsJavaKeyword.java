package com.company;

import java.util.Scanner;

public class IsJavaKeyword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userString = scanner.next();

        if (userString.equals("while") || userString.equals("for")) {
            System.out.println("is a java keyword");
        }
        else {
            System.out.println("Is not a java keyword");
        }
    }

}
