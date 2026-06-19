package ParkingLot.Factory;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Models.Bike;
import ParkingLot.Models.Car;
import ParkingLot.Models.Truck;
import ParkingLot.Models.Vehicle;

public class VehicleFactory {

    public Vehicle createVehicle(VehicleType vehicleType, String vehicleNumber){
        return switch (vehicleType){
            case VehicleType.CAR -> new Car(vehicleNumber);
            case VehicleType.BIKE -> new Bike(vehicleNumber);
            case VehicleType.TRUCK -> new Truck(vehicleNumber);
        };
    }
}
