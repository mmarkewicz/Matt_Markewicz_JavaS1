package com.company.implementations;

import com.company.interfaces.Converter;

public class ConverterSwitch implements Converter {

    public String convertMonth(int monthNumber) {
        String month = "";
        switch (monthNumber) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = null;
                System.out.println("Error: Invalid Input");
                break;
        }
        return month;
    }

    public String convertDay(int dayNumber) {
        String day = "";
        switch(dayNumber) {
            case 1:
            case 8:
            case 15:
            case 22:
            case 29:
                day = "Sunday";
                break;
            case 2:
            case 9:
            case 16:
            case 23:
            case 30:
                day = "Monday";
                break;
            case 3:
            case 10:
            case 17:
            case 24:
            case 31:
                day = "Tuesday";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                day = "Wednesday";
                break;
            case 5:
            case 12:
            case 19:
            case 26:
                day = "Thursday";
                break;
            case 6:
            case 13:
            case 20:
            case 27:
                day = "Friday";
                break;
            case 7:
            case 14:
            case 21:
            case 28:
                day = "Saturday";
                break;
            default:
                day = null;
                break;

        }
        return day;
    }
}
