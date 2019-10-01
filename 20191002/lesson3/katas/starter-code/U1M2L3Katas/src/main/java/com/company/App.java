package com.company;

public class App {

    public TV createTV() {
        TV methodTV = new TV("Zenith", "U2121H", 83, "NBC", 55, false);
        return methodTV;
    }

    public Radio createRadio() {
        Radio methodRadio = new Radio("Sony", "V32", 2, "WUNV", 30, true);
        return methodRadio;
    }

    public Microwave createMicrowave() {
        Microwave methodMicrowave = new Microwave("Haier", "X1200w", 45, "12:00", false);
        return methodMicrowave;
    }

    public CoffeeMaker createCoffeeMaker() {
        CoffeeMaker methodCoffeeMaker = new CoffeeMaker("Sunbeam", "C12", 12, 8, true);
        return methodCoffeeMaker;
    }

    public Car createCar() {
        Car methodCar = new Car("Honda", "Accord", "Sedan", "Blue", "2.6L V6", "CVT", 4, 31.7, 25218);
        return methodCar;
    }

    public ComputerMouse createComputerMouse() {
        ComputerMouse methodMouse = new ComputerMouse("Razer", "Naga", 960, 540, new int[]{0, 0});
        return methodMouse;
    }
}
