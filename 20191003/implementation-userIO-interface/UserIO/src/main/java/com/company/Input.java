package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class Input implements UserIO {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        int res = scanner.nextInt();
        return res;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        long res = scanner.nextLong();
        return res;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        double res = scanner.nextDouble();
        return res;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        float res = scanner.nextFloat();
        return res;
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        String res = scanner.next();
        return res;
    }
}
