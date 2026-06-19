package ParkingLot.Strategy.Pricing;

import ParkingLot.Enums.VehicleType;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Map;

public class EventBasedPricing extends PricingStrategy {

    private static final Map<VehicleType, Double> eventHourlyRate = Map.of(
            VehicleType.CAR, 50.0,
            VehicleType.BIKE, 30.0,
            VehicleType.TRUCK, 70.0
    );

    @Override
    public double calculate(VehicleType vehicleType, LocalTime entryTime, LocalTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);
        long totalMinutes = duration.toMinutes();
        double totalHours = Math.ceil(totalMinutes / 60.0);

        return totalHours * eventHourlyRate.get(vehicleType);
    }
}
