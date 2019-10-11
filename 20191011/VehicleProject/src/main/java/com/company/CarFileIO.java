package com.company;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;


public class CarFileIO {
    static List<Car> getCars(String filename) throws FileNotFoundException {
        return new CsvToBeanBuilder<Car>(new FileReader(filename)).withType(Car.class).build().parse();
    }

    static void writeCars(List<Car> cars, String filename) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        // Now let's write the motorcycle list to another file
        Writer writer = new FileWriter(filename);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
        beanToCsv.write(cars);
        writer.close();
    }
}
