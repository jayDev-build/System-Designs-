package Uber.Strategy.Pricing;

import Uber.Models.Location;

public class LocationBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFarePrice(Location src, Location dest) {
        double distanceInKm = Math.sqrt(Math.pow(src.lat - dest.lat, 2) + Math.pow(src.lon - dest.lon, 2));
        return distanceInKm;
    }
}
