package ParkingLot.Models.Vehicle;

import ParkingLot.Enums.VehicleType;

public class Car extends Vehicle {

    public Car(String vehicleNumber){
        super(vehicleNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
