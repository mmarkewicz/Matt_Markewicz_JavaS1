package com.company;

import java.util.Random;

public class TimesTo7 {
    public static void main(String[] args) {

        int timesRolled = 0;
        int numberOf7sRolled = 0;

        while (timesRolled < 100) {
            Random rand = new Random();
            int low = 1;
            int high = 7;
            int result = rand.nextInt(high-low) + low;
            int result2 = rand.nextInt(high-low) + low;

            if (result + result2 == 7 && numberOf7sRolled == 0) {
                timesRolled++;
                System.out.println("Rolls until first 7: " + timesRolled);
                numberOf7sRolled++;
            } else if (result + result2 == 7 && numberOf7sRolled > 0) {
                timesRolled++;
                numberOf7sRolled++;
            } else {
                timesRolled++;
            }

            if (timesRolled == 99) {
                System.out.println("Total number of 7's rolled: " + numberOf7sRolled);
            }



        }

    }
}
