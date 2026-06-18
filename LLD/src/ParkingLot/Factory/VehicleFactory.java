package ParkingLot.Factory;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Vehicle.Bike;
import ParkingLot.Vehicle.Car;
import ParkingLot.Vehicle.Truck;
import ParkingLot.Vehicle.Vehicle;

public abstract class VehicleFactory {

    public Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber){
        return switch (vehicleType){
            case VehicleType.CAR -> new Car(vehicleNumber);
            case VehicleType.BIKE -> new Bike(vehicleNumber);
            case VehicleType.TRUCK -> new Truck(vehicleNumber);
        };
    }
}
