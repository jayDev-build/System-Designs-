package DesignPatterns.Builder;

public class Client {
    public static void main(String[] args) {
        Car.Builder builder = new Car.Builder();
        Car car = builder
                .make("Toyota")
                .model("Corolla")
                .year(2024)
                .colour("grey")
                .price(1700000)
                .licensePlate("AB1234")
                .build();

        System.out.println("Make: " + car.make);
        System.out.println("Model: " + car.model);
        System.out.println("Year: " + car.year);
        System.out.println("Colour: " + car.colour);
        System.out.println("Price: " + car.price);
        System.out.println("licensePlate: " + car.licensePlate);

    }
}
