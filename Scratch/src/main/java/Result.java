import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'printAnimalAndRunningDistance' function below.
     *
     * The function accepts DOUBLE minutes as parameter.
     */

    Animal dog = new Animal("Dog", 7.0);
    Animal human = new Animal("Human", 5.0);

    public static void printAnimalAndRunningDistance(double minutes) {
        //
    }

    /* helper method to print the result */
    private static void printResult(String name, double distance ) {
        System.out.format("%s ran %.2f miles\n", name, distance);
    }
}

class Animal {
    private String typeName;
    private double avgRunPerHour;

    public Animal(String name, double avg) {
        this.typeName = name;
        this.avgRunPerHour = avg;
    }

    public String getName() {
        return this.name;
    }

    public double getAvgRunPerHour() {
        return this.avgRunPerHour;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvgRunPerHour(double avg) {
        this.avgRunPerHour = avg;
    }
}

class Run {

    private Animal animal;

    public Run(Animal animal) {
        this.animal = animal;
    }

    public double getDistance(double minutes) {
        return this.animal.getAvgRunPerHour() * (minutes/60);
    }
}