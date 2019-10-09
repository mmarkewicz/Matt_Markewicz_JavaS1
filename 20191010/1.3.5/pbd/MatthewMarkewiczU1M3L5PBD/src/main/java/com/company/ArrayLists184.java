package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayLists184 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        List<Integer> arrList = new ArrayList<>();
        boolean isArrayFilled = false;

        while(!isArrayFilled) {
            int randomNum = rand.nextInt(50) + 1;
            arrList.add(randomNum);
            if (arrList.size() == 10) {
                isArrayFilled = true;
            }
        }

        System.out.println("ArrayList: " + arrList);
        System.out.println("Value to find: ");
        int userInt = scanner.nextInt();
        boolean isInArr = false;

        for (int num : arrList) {
            if (num == userInt) {
                isInArr = true;
            }
        }

        if (isInArr) {
            int index = arrList.lastIndexOf(userInt);
            System.out.println(userInt + " is in the ArrayList at slot " + index);
        } else {
            System.out.println(userInt + " is not in the ArrayList");
        }

    }
}
