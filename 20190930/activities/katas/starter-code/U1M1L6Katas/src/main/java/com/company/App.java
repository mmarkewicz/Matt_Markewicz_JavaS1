package com.company;

public class App {

    // 1: total
    public static int total(int[] arr) {
        int total = 0;
        for (int element : arr) {
            total += element;
        }
        return total;
    }

    // 2: totalOdd
    public static int totalOdd(int[] arr) {
        int total = 0;
        for (int i = 1; i < arr.length; i += 2) {
            total += arr[i];
        }
        return total;
    }

    // 3: totalEven
    public static int totalEven(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i += 2) {
            total += arr[i];
        }
        return total;
    }

    // 4: secondLargestNumber
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

    // 5: swapFirstAndLast
    public static String[] swapFirstAndLast(String[] array) {
        String first = array[0];
        String last = array[array.length - 1];
        array[0] = last;
        array[array.length - 1] = first;
        return array;
    }

    // 6: reverse
    public static int[] reverse(int[] array) {
        int[] arrayCopy = new int[array.length];
        int reverseIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            arrayCopy[i] = array[reverseIndex];
            reverseIndex -= 1;
        }
        return arrayCopy;
    }

    // 7: concatenateString
    public static String concatenateString(String[] array) {
        String string = "";
        for (String element : array) {
            string += element;
        }
        return string;
    }

    // 8: everyThird
    public static int[] everyThird(int[] array) {
        int outputArrLength = 0;
        int outputArrIndex = 0;
        for (int i = 2; i < array.length; i+=3) {
            outputArrLength++;
        }
        int[] outputArr = new int[outputArrLength];
        for (int i = 2; i < array.length; i += 3) {
            outputArr[outputArrIndex] = array[i];
            outputArrIndex++;
        }
        if (outputArr.length == 0) {
            outputArr = null;
        }
        return outputArr;
    }

    // 9: lessThanFive
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

    // -------------------- Challenge --------------------
//  1: splitAtFive
/*  Create a method called splitAtFive which takes in an array of ints.
    This method should split the array into two new arrays, one holding the values less than 5 and the other holding the values equal to or greater than 5.
    Return a two-dimensional array, with the small-value array first.
    Your code should work for an array of any size. */
    public static int[][] splitAtFive(int[] array) {
        int lessThan5 = 0;
        int greaterThanOrEqualTo5 = 0;

        // find how many numbers satisfy the criteria
        for (int element : array) {
            if (element < 5) {
                lessThan5++;
            } else {
                greaterThanOrEqualTo5++;
            }
        }

        // build arrays with the results and initialize indices
        int[] lessThan5Array = new int[lessThan5];
        int[] greaterThanOrEqualToArray = new int[greaterThanOrEqualTo5];
        int lessThan5Index = 0;
        int greaterThanOrEqualToIndex = 0;

        // populate arrays
        for (int element : array) {
            if (element < 5) {
                lessThan5Array[lessThan5Index] = element;
                lessThan5Index++;
            } else {
                greaterThanOrEqualToArray[greaterThanOrEqualToIndex] = element;
                greaterThanOrEqualToIndex++;
            }
        }

        // populate multidimensional array with calculated arrays
        int[][] outputArrays = {lessThan5Array, greaterThanOrEqualToArray};
        return outputArrays;
    }


//  2: evensAndOdds
/*  Create a method called evensAndOdds which takes in an array of Strings.
    Create two new arrays, one holding the values of the even indices and the other the values of the odd.
    Return a two-dimensional array, with the even-indices array first.
    Your code should work for an array of any size. */

}
