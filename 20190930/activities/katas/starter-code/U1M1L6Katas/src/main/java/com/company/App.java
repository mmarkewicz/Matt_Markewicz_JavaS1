package com.company;

public class App {

    public static int total(int[] arr) {
        int total = 0;
        for (int element : arr) {
            total += element;
        }
        return total;
    }

    public static int totalOdd(int[] arr) {
        int total = 0;
        for (int i = 1; i < arr.length; i += 2) {
            total += arr[i];
        }
        return total;
    }

    public static int totalEven(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i += 2) {
            total += arr[i];
        }
        return total;
    }

    public static int secondLargestNumber(int[] arr) {
        int largest = arr[0];
        int secondLargest = arr[1];
        for (int element : arr) {
            if (element > largest) {
                secondLargest = largest;
                largest = element;
            } else if (element > secondLargest && element < largest) {
                secondLargest = element;
            }
        }
        return secondLargest;
    }

    public static String[] swapFirstAndLast(String[] array) {
        String first = array[0];
        String last = array[array.length - 1];
        array[0] = last;
        array[array.length - 1] = first;
        return array;
    }

    public static int[] reverse(int[] array) {
        int[] arrayCopy = new int[array.length];
        int reverseIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[reverseIndex];
            reverseIndex -= 1;
        }
        return arrayCopy;
    }

    public static String concatenateString(String[] array) {
        String string = "";
        for (String element : array) {
            string += element;
        }
        return string;
    }

    public static int[] everyThird(int[] array) {
        int outputArrLength = 0;
        for (int i = 2; i < array.length; i+=3) {
            outputArrLength++;
        }
        int[] outputArr = new int[outputArrLength];
        int outputArrIndex = 0;
        for (int i = 2; i < array.length; i += 3) {
            outputArr[outputArrIndex] = array[i];
            outputArrIndex++;
        }
        if (outputArr.length == 0) {
            outputArr = null;
        }
        return outputArr;
    }

    public static int[] lessThanFive(int[] array) {
        int outputArrayLength = 0;
        int outputArrayIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 5) {
                outputArrayLength++;
            }
        }
        int[] outputArray = new int[outputArrayLength];
        for (int element : array) {
            if (element < 5) {
                outputArray[outputArrayIndex] = element;
                outputArrayIndex++;
            }
        }
        if (outputArray.length == 0) {
            outputArray = null;
        }
        return outputArray;
    }

}
