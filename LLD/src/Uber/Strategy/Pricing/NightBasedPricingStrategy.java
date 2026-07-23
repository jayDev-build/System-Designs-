package Uber.Strategy.Pricing;

import java.time.LocalTime;

import Uber.Models.Location;

public class NightBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFarePrice(Location src, Location dest) {

        LocalTime time = LocalTime.now();
        if (time.isAfter(LocalTime.of(22, 0)) || time.isBefore(LocalTime.of(6, 0))) {
            return 50.0;
        }

        return 0;
    }
}
