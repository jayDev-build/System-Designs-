package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

public class Truck extends Vehicle {

    public Truck(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
