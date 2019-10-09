package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayLists181 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> arrList = new ArrayList<>();
        boolean isArrayFilled = false;

        while(!isArrayFilled) {
            int randomNum = rand.nextInt(100) + 1;
            arrList.add(randomNum);
            if (arrList.size() == 10) {
                isArrayFilled = true;
            }
        }

        List<Integer> arrList2 = new ArrayList<>();
        for (int i = 0; i < arrList.size() - 1; i++) {
            arrList2.add(arrList.get(i));
        }
        arrList2.add(-7);
        System.out.println("ArrayList1: " + arrList);
        System.out.println("ArrayList2: " + arrList2);
    }
}
