package DesignPatterns.AbstractFactory;

public interface CarFactory {
    Engine createEngine();
    DashBoard createDashBoard();
    Tyres createTyres();

}
