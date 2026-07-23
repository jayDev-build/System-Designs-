package Uber.Strategy.Pricing;

import Uber.Models.Location;

public interface PricingStrategy {
    public double calculateFarePrice(Location src, Location dest);
}
