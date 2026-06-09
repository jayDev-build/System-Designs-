package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Factory hyundaiFactory = new HyundaiFactory();
        Factory marutiFactory = new MarutiFactory();

        Car hyundaiCar = hyundaiFactory.createCar();
        Car marutiCar = marutiFactory.createCar();

        hyundaiCar.drive();
        marutiCar.drive();
    }
}