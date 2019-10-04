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
        } else if (dayNumber == 1 || dayNumber % 8 == 0) {
            output = "Sunday";
        } else if (dayNumber == 2 || dayNumber % 9 == 0) {
            output = "Monday";
        } else if (dayNumber == 3 || dayNumber % 10 == 0) {
            output = "Tuesday";
        } else if (dayNumber == 4 || dayNumber % 11 == 0) {
            output = "Wednesday";
        } else if (dayNumber == 5 || dayNumber % 12 == 0) {
            output = "Thursday";
        } else if (dayNumber == 6 || dayNumber % 6 == 0) {
            output = "Friday";
        } else if (dayNumber == 7 || dayNumber % 7 == 0) {
            output = "Saturday";
        }
        return output;
    }

}
