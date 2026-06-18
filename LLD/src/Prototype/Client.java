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

        System.out.println("clone Make: " + carClone.getMake());
        System.out.println("clone Model: " + carClone.getModel());
        System.out.println("clone licensePlace: " + carClone.getLicensePlate());

        carClone.setLicensePlate("AB3456");
        System.out.println("\nUpdated licensePlace for clone: " + carClone.getLicensePlate());
        System.out.println("\noriginal licensePlace for clone: " + car.getLicensePlate());
    }
}
