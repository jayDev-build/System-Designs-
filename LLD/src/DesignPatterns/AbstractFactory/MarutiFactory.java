package DesignPatterns.AbstractFactory;

public class MarutiFactory implements CarFactory{


    @Override
    public Engine createEngine() {
        return new MarutiEngine();
    }

    @Override
    public DashBoard createDashBoard() {
        return new MarutiDashBoard();
    }

    @Override
    public Tyres createTyres() {
        return new MarutiTyres();
    }
}
