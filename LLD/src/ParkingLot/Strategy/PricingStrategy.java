package ParkingLot.Strategy;

import java.time.LocalDateTime;
import java.time.LocalTime;

import ParkingLot.Enums.*;

public abstract class PricingStrategy {
    public abstract double calculate(VehicleType vehicleType, LocalTime entryTime, LocalTime exitTime);
}
