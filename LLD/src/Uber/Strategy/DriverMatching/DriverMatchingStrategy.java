package Uber.Strategy.DriverMatching;

import Uber.Models.Driver;
import Uber.Models.Location;
import java.util.List;

public abstract class DriverMatchingStrategy {

    public abstract Driver findDriver(Location location, List<Driver> drivers);

}
