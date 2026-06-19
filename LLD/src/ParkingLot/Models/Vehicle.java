package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

public abstract class Vehicle {
    private String vehicleNumber;

    public Vehicle(String vehicleNumber){
        this.vehicleNumber = vehicleNumber;
    }
    public abstract VehicleType getType();
}
