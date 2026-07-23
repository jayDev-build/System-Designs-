package Uber.Strategy.Pricing;

import java.time.LocalTime;

import Uber.Models.Location;

public class NightBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFarePrice(Location src, Location dest) {
        LocalTime time = LocalTime.now();

        if (time.getHour() >= 22 && time.getHour() <= 6) {
            return 50.0;
        }

        return 0;
    }
}
