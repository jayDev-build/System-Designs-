package ParkingLot.Vehicle;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Factory.VehicleFactory;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
