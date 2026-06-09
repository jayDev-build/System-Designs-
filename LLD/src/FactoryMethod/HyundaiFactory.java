package FactoryMethod;

public class HyundaiFactory implements Factory{
    @Override
    public Car createCar() {

        return new HyundaiCar();
    }
}
