package com.company.implementations;

public class ConverterApplication {
    public static void main(String[] args) {
        ConverterIf converterIf = new ConverterIf();
        String month = converterIf.convertMonth(5);
        String day = converterIf.convertDay(15);
        System.out.println(month + " " + day);
    }
}
