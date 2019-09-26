package com.company;

public class App {

    // subtract
    // take in 2 int parameters (a and b) and return value of a - b
    public static int subtract(int a, int b) {
        return a - b;
    }
    // subtractOrZero
    // take in 2 int parameters (a and b) and return value of a - b, unless the result is less than 0, in which case, return 0
    public static int subtractOrZero(int a, int b) {
        int result = a - b;
        if (result > 0) {
            return result;
        }
        else {
            return 0;
        }
    }
    // max
    // take in 3 int parameters (a, b, and c) and return value of largest of the three
    public static int max(int a, int b, int c) {
        int highest;
        if (a > b && a > c) {
            highest = a;
        }
        else if (b > a && b > c) {
            highest = b;
        }
        else {
            highest = c;
        }
        return highest;
    }
    // min
    // take in 3 int parameters (a, b, and c) and return value of smallest of the three
    public static int min(int a, int b, int c) {
        int lowest;

        if (a < b && a < c) {
            lowest = a;
        } else if (b < a && b < c) {
            lowest = b;
        } else {
            lowest = c;
        }

        return lowest;
    }
    // isLarger
    // take in 2 int parameters (first and second) and return true if the first is greater than the second
    public static boolean isLarger(int first, int second) {
        boolean isLarger = true;
        if (second > first) {
            isLarger = false;
        }
        return isLarger;
    }

}
