package FactoryMethod;

public class MarutiFactory implements Factory{
    @Override
    public Car createCar() {

        return new MarutiCar();
    }
}
