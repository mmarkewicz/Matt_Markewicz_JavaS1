package com.company.implementations;

import com.company.interfaces.Converter;

public class ConverterIf implements Converter {

    public String convertMonth(int monthNumber) {
        if (monthNumber == 1) {
            return "January";
        } else if (monthNumber == 2) {
            return "February";
        } else if (monthNumber == 3) {
            return "March";
        } else if (monthNumber == 4) {
            return "April";
        } else if (monthNumber == 5) {
            return "May";
        } else if (monthNumber == 6) {
            return "June";
        } else if (monthNumber == 7) {
            return "July";
        } else if (monthNumber == 8) {
            return "August";
        } else if (monthNumber == 9) {
            return "September";
        } else if (monthNumber == 10) {
            return "October";
        } else if (monthNumber == 11) {
            return "November";
        } else if (monthNumber == 12) {
            return "December";
        } else {
            System.out.println("Error: That is not a valid month.");
            return null;
        }
    }

    public String convertDay(int dayNumber) {
        String output = "";
        if (dayNumber > 31) {
            System.out.println("That is not a valid input");
            output = null;
        } else if (dayNumber == 1 || dayNumber == 8 || dayNumber == 15 || dayNumber == 22 || dayNumber == 29) {
            output = "Sunday";
        } else if (dayNumber == 2 || dayNumber == 9 || dayNumber == 16 || dayNumber == 23 || dayNumber == 30) {
            output = "Monday";
        } else if (dayNumber == 3 || dayNumber == 10 || dayNumber == 17 || dayNumber == 24 || dayNumber == 31) {
            output = "Tuesday";
        } else if (dayNumber == 4 || dayNumber == 11 || dayNumber == 18 || dayNumber == 25) {
            output = "Wednesday";
        } else if (dayNumber == 5 || dayNumber == 12 || dayNumber == 19 || dayNumber == 26) {
            output = "Thursday";
        } else if (dayNumber == 6 || dayNumber == 13 || dayNumber == 20 || dayNumber == 27) {
            output = "Friday";
        } else if (dayNumber == 7 || dayNumber == 14 || dayNumber == 21 || dayNumber == 28) {
            output = "Saturday";
        }
        return output;
    }

}
