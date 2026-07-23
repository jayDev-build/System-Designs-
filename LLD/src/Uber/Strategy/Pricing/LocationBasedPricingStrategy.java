package Uber.Strategy.Pricing;

import Uber.Models.Location;

public class LocationBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFarePrice(Location src, Location dest) {
        double distanceInKm = src.distanceTo(dest);
        return distanceInKm;
    }
}
