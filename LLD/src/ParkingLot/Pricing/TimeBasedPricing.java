package ParkingLot.Pricing;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeBasedPricing extends PricingStrategy{

    private static final LocalTime peakStart = LocalTime.of(8, 0);
    private static final LocalTime peakEnd = LocalTime.of(15, 0);

    private boolean isPeak(LocalTime hour){
        return hour.isAfter(peakStart) && hour.isBefore(peakEnd);
    }

    @Override
    public double calculate(VehicleType vehicleType, LocalTime entryTime, LocalTime exitTime){
        if(exitTime.isBefore(entryTime)){
            throw new IllegalArgumentException("Exit Can Not Be Before Entry");
        }
        Duration duration = Duration.between(entryTime, exitTime);
        long totalMinutes = duration.toMinutes();
        double totalHours = Math.ceil(totalMinutes / 60.0);

        int peakHours = 0;
        int nonPeakHours = 0;

        LocalTime cursor = entryTime.truncatedTo(ChronoUnit.HOURS);

        for(int i = 0; i < totalHours; i++){
            if(isPeak(cursor)) peakHours++;
            else nonPeakHours++;
            cursor = cursor.plusHours(1);
        }

        Double peakRate = switch (vehicleType){
            case VehicleType.CAR -> 20.0;
            case VehicleType.BIKE -> 15.0;
            case VehicleType.TRUCK -> 50.0;
        };

        Double nonPeakRate = switch (vehicleType){
            case VehicleType.CAR -> 20.0;
            case VehicleType.BIKE -> 10.0;
            case VehicleType.TRUCK -> 30.0;
        };

        return peakHours * peakRate + nonPeakHours * nonPeakRate;
    }
}
