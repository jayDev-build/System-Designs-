package ParkingLot.Vehicle;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Factory.VehicleFactory;

public class Bike extends Vehicle {

    public Bike(String vehicleNumber){
        super(vehicleNumber);
    }
    @Override
    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
