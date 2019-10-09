package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TelevisionReader {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            List<Television> tvs = FileIO.getTelevisions("televisions.csv");

            // find all tvs with a screen size greater than 60in
            int size = 60;
            System.out.println("All TV's with a screen size greater than " + size + " inches");
            System.out.println(" ");
            System.out.println("------------------------");

            tvs
                    .stream()
                    .filter(tv -> tv.getScreenSize() > 60)
                    .forEach(tv -> {
                        System.out.println(tv.getScreenSize() + " inch " + tv.getBrand() + tv.getModel() + " for " + tv.getPrice());
                        System.out.println("------------------------");
                    });

            // group all tvs into a map by brand
            Map<String, List<Television>> groupedTVs =
                    tvs
                        .stream()
                        .collect(Collectors.groupingBy(tv -> tv.getBrand()));

            Set<String> brands = groupedTVs.keySet();
            for (String brand : brands) {
                System.out.println(brand);
            }

            // find and display the avg screen size
            double screenSizeAvg =
                    tvs
                        .stream()
                        .mapToInt(tv -> tv.getScreenSize())
                        .average()
                        .getAsDouble();

            System.out.println(" ");
            System.out.println("Screen Size Avg: " + screenSizeAvg);

            // find max screen size
            int max =
                    tvs
                        .stream()
                        .mapToInt(tv -> tv.getScreenSize())
                        .max().orElseThrow(Exception::new);

            System.out.println(" ");
            System.out.println("The largest screen size is " + max);

        } catch (FileNotFoundException e) {
            System.out.println("err - file not found");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
