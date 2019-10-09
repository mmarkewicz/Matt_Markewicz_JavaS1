package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayLists180 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> arrList = new ArrayList<>();
        boolean isArrayFilled = false;

        while(!isArrayFilled) {
            int randomNum = rand.nextInt(100) + 1;
            arrList.add(randomNum);
            if (arrList.size() == 1000) {
                isArrayFilled = true;
            }
        }

        System.out.println("ArrayList: " + arrList);
    }
}