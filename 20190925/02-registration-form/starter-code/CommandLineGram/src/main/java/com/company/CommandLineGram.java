package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First Name: ");
        String firstName = scanner.next();

        System.out.println("Last Name: ");
        String lastName = scanner.next();

        System.out.println("Email: ");
        String email = scanner.next();

        System.out.println("Twitter Handle: ");
        String handle = scanner.next();

        System.out.println("Age: ");
        int age = scanner.nextInt();

        System.out.println("Country: ");
        String country = scanner.next();

        System.out.println("Profession: ");
        scanner.nextLine();
        String profession = scanner.nextLine();

        System.out.println("Favorite OS: ");
        String favoriteOS = scanner.next();

        System.out.println("Favorite Language: ");
        String favoriteLanguage = scanner.next();

        System.out.println("Favorite Comp Scientist: ");
        scanner.nextLine();
        String favoriteScientist = scanner.nextLine();

        System.out.println("Favorite Keyboard Shortcut: ");
        String favoriteShortcut = scanner.next();

        System.out.println("Have you ever built your own computer?");
        String everBuilt = scanner.next();

        System.out.println("If you could be any superhero, who would it be? ");
        scanner.nextLine();
        String superhero = (scanner.nextLine());

        System.out.println("1. " + firstName);
        System.out.println("2. " + lastName);
        System.out.println("3. " + email);
        System.out.println("4. " + handle);
        System.out.println("5. " + age);
        System.out.println("6. " + country);
        System.out.println("7. " + profession);
        System.out.println("8. " + favoriteOS);
        System.out.println("9. " + favoriteLanguage);
        System.out.println("10. " + favoriteScientist);
        System.out.println("11. " + favoriteShortcut);
        System.out.println("12. " + everBuilt);
        System.out.println("13. " + superhero);
    }
}
