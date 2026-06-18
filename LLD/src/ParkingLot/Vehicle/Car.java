package ParkingLot.Vehicle;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Factory.VehicleFactory;

public class Car extends Vehicle {

    public Car(String vehicleNumber){
        super(vehicleNumber);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}
