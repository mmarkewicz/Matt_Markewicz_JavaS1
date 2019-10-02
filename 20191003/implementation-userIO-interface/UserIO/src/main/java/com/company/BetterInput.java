package com.company;

import com.company.interfaces.UserIO;

import java.util.Scanner;

public class BetterInput implements UserIO {
    Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt(String prompt) {
        try {
            System.out.println(prompt);
            int res = Integer.parseInt(scanner.nextLine());
            return res;
        } catch (Exception e) {
            return readInt(prompt);
        }
    }

    @Override
    public long readLong(String prompt) {
        try {
            System.out.println(prompt);
            long res = Long.parseLong(scanner.nextLine());
            return res;
        } catch (Exception e) {
            return readLong(prompt);
        }
    }

    @Override
    public double readDouble(String prompt) {
        try {
            System.out.println(prompt);
            double res = Double.parseDouble(scanner.nextLine());
            return res;
        } catch (Exception e) {
            return readDouble(prompt);
        }
    }

    @Override
    public float readFloat(String prompt) {
        try {
            System.out.println(prompt);
            float res = Float.parseFloat(scanner.nextLine());
            return res;
        } catch (Exception e) {
            return readFloat(prompt);
        }
    }

    @Override
    public String readString(String prompt) {
        try {
            System.out.println(prompt);
            String res = scanner.nextLine();
            return res;
        } catch (Exception e) {
            return readString(prompt);
        }
    }
}
