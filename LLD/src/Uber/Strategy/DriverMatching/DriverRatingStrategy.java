package Uber.Strategy.DriverMatching;

import Uber.Models.Driver;
import Uber.Models.Location;
import java.util.List;

public class DriverRatingStrategy extends DriverMatchingStrategy {
    @Override
    public Driver findDriver(Location location, List<Driver> drivers) {
        Driver bestDriver = null;
        double maxRating = Double.MIN_VALUE;

        for (Driver driver : drivers) {
            if (driver.rating > maxRating) {
                maxRating = driver.rating;
                bestDriver = driver;
            }
        }
        return bestDriver;
    }
}
