package com.company;

import java.util.LinkedList;
import java.util.List;

public class LinkedListApp {
    // complete
    public static int total (List<Integer> numbers) {

        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }

        return sum;
    }

    // complete
    public static int totalEven (List<Integer> numbers) {

        int sum = 0;
        for(int i = 0; i < numbers.size(); i += 2) {
            sum += numbers.get(i);
        }

        return sum;
    }

    // complete
    public static List<String> swapFirstAndLast(List<String> strings) {

        String temp = strings.get(0);
        strings.remove(0);
        strings.add(0, strings.get(strings.size() -1 ));
        strings.add(strings.size() - 1, temp);
        strings.remove(strings.size() -1 );

        return strings;
    }

    // complete
    public static List<Integer> reverse(List<Integer> numbers) {

        List<Integer> reversed = new LinkedList<>();
        int numbersArrIndex = numbers.size() - 1;
        for(int i = 0; i < numbers.size(); i++) {
            reversed.add(i, numbers.get(numbersArrIndex));
            numbersArrIndex--;
        }

        return reversed;
    }

    // complete
    public static List<Integer> lessThanFive(List<Integer> numbers) {

        List<Integer> lessThanFive = new LinkedList<>();
        int lessThanFiveIndex = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 5) {
                lessThanFive.add(lessThanFiveIndex, numbers.get(i));
                lessThanFiveIndex++;
            }
        }

        if (lessThanFive.size() == 0) {
            return null;
        } else {
            return lessThanFive;
        }
    }
}
