package ParkingLot.Pricing;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Strategy.PricingStrategy;

import java.time.LocalDateTime;

public class TimeBasedPricing extends PricingStrategy {
    @Override
    public double calculate(VehicleType vehicleType, LocalDateTime entryTime, LocalDateTime exitTime) {
        return 0;
    }
}
