package ParkingLot.Strategy;

import java.time.LocalDateTime;
import ParkingLot.Enums.*;

public abstract class PricingStrategy {
    public abstract double calculate(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime);
}
