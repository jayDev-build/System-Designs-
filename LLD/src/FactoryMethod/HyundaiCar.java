package FactoryMethod;

public class HyundaiCar implements Car{

    @Override
    public void drive() {
        System.out.println("Driving Hyundai car");
    }
}
