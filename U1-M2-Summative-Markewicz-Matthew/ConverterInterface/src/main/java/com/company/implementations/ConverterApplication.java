package com.company.implementations;

public class ConverterApplication {
    public static void main(String[] args) {
        ConverterIf converterIf = new ConverterIf();
        String month = converterIf.convertMonth(5);
        String day = converterIf.convertDay(8);
        System.out.println(month + " " + day);

        ConverterSwitch converterSwitch = new ConverterSwitch();
        String switchMonth = converterSwitch.convertMonth(5);
        String switchDay = converterSwitch.convertDay(8);
        System.out.println(switchMonth + " " + switchDay);
    }
}
