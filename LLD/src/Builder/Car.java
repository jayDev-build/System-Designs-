package Builder;

public class Car {
    public String make;
    public String model;
    public int year;
    public String colour;
    public double price;
    public String licensePlate;

    private Car(Builder build){
        this.make = build.make;
        this.model = build.model;
        this.year = build.year;
        this.colour = build.colour;
        this.price = build.price;
        this.licensePlate = build.licensePlate;
    }

    static class Builder {

        private String make;
        private String model;
        private int year;
        private String colour;
        private double price;
        private String licensePlate;

        Builder make(String make){
            this.make = make;
            return this;
        }

        Builder model(String model){
            this.model = model;
            return this;
        }

        Builder year(int year){
            this.year = year;
            return this;
        }

        Builder colour(String colour){
            this.colour = colour;
            return this;
        }

        Builder price(double price){
            this.price = price;
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
}
