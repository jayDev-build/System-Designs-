package DesignPatterns.Prototype;

public interface Vehicle {

    Vehicle clone();
    String getMake();
    String getModel();
    String getLicensePlate();
    void setMake(String make);
    void setModel(String model);
    void setLicensePlate(String licensePlate);

}
