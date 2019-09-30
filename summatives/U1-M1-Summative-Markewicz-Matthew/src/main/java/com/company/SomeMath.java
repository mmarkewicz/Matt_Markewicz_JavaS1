package com.company;

public class SomeMath {

    // total5
    public static int total5(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    // average5
    public static double average5(int a, int b, int c, int d, int e) {
        return (double) (a + b + c + d + e) / 5;
    }

    // largest5
    public static double largest5(double a, double b, double c, double d, double e) {
        double largest = a;
        if (a > b && a > c && a > d && a > e) {
            largest = a;
        } else if (b > a && b > c && b > d && b > e) {
            largest = b;
        } else if (c > a && c > b && c > d && c > e) {
            largest = c;
        } else if (d > a && d > c && d > b && d > e) {
            largest = d;
        } else if (e > a && e > c && e > d && e > b) {
            largest = e;
        }
        return largest;
    }

    public static void main(String[] args) {
        int total5Result = SomeMath.total5(1, 2, 3, 4, 5);
        System.out.println(total5Result);

        double average5Result = SomeMath.average5(1, 3, 5, 7, 9);
        System.out.println(average5Result);

        double largest5Result = SomeMath.largest5(42.0, 35.1, 2.3, 40.2, 15.6);
        System.out.println(largest5Result);
    }
}
