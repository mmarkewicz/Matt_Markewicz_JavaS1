package com.company;

public class ArrayFunReverseIt {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] reverseArr = new int[5];
        int reverseArrIndex = arr.length - 1;

        for (int element : arr) {
            reverseArr[reverseArrIndex] = element;
            reverseArrIndex--;
        }

        for (int element : arr) {
            System.out.println(element);
        }

        for (int element : reverseArr) {
            System.out.println(element);
        }
    }

}
