package DesignPatterns.Prototype;

public class Car implements Vehicle{
    private String make;
    private String model;
    private String licensePlate;

    private Car(Builder build){
        this.make = build.make;
        this.model = build.model;
        this.licensePlate = build.licensePlate;
    }

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setLicensePlate(String licensePlate){
        this.licensePlate = licensePlate;
    }

    static class Builder {

        private String make;
        private String model;
        private String licensePlate;

        Builder make(String make){
            this.make = make;
            return this;
        }

        Builder model(String model){
            this.model = model;
            return this;
        }

        Builder licensePlate(String plate){
            this.licensePlate = plate;
            return this;
        }

        Car build(){
            return new Car(this);
        }

    }

    @Override
    public Vehicle clone() {
        Builder builder = new Builder();
        return builder
                .make(this.make)
                .model(this.model)
                .licensePlate(this.licensePlate)
                .build();
    }

    @Override
    public String getMake() {
        return this.make;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

}
