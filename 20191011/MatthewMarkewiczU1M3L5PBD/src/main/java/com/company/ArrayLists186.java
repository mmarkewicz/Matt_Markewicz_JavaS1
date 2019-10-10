package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayLists186 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        while(list.size() < 10) {
            int rand = random.nextInt(100) + 1;
            list.add(rand);
        }

        int max = list.get(0);

        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }

        System.out.println(max + " at index " + list.indexOf(max) + " is the largest integer in the array");
    }
}
