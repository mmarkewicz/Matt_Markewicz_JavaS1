package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How old are you?");
        int userAge = scanner.nextInt();

        if (userAge < 14) {
            System.out.println("What grade are you in?");
            String userGrade = scanner.next();
            System.out.println("Wow! " + userGrade + " grade - that sounds exciting!");
        } else if (userAge >= 14 && userAge <= 18) {
            System.out.println("Are you planning on going to college? (yes or no)");
            String userCollege = scanner.next();
            if (userCollege.equals("yes")) {
                System.out.println("Which college?");
                String userCollegeName = scanner.next();
                System.out.println(userCollegeName + " is a great school!");
            }
            else if (userCollege.equals("no")) {
                System.out.println("What do you want to do after school?");
                String userAfterHS = scanner.next();
                System.out.println("Wow, " + userAfterHS +" sounds like a plan!");
            }
        } else if (userAge > 18) {
            System.out.println("What is your job?");
            String userJob = scanner.next();
            System.out.println(userJob + " sounds like a great job!");
        }
    }

}
