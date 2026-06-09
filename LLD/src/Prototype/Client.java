package Prototype;

public class Client {
    public static void main(String[] args) {
        Car.Builder builder = new Car.Builder();
        Car car = builder
                .make("Toyota")
                .model("Corolla")
                .licensePlate("AB1234")
                .build();

        Vehicle carClone = car.clone();

        System.out.println("Make: " + carClone.getMake());
        System.out.println("Model: " + carClone.getModel());
        System.out.println("licensePlace: " + carClone.getLicensePlate());
    }
}
