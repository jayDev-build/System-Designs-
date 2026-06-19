package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

public class Bike extends Vehicle {

    public Bike(String vehicleNumber){
        super(vehicleNumber);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
