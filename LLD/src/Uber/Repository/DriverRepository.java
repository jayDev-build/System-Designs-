package Uber.Repository;

import Uber.Models.Driver;

import Uber.Models.Location;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DriverRepository {
    HashMap<String, Driver> driverMap;

    public DriverRepository() {
        driverMap = new HashMap<>();
    }

    public void saveDriver(Driver driver) {
        driverMap.put(driver.id, driver);
    }

    public Driver getDriver(String id) {
        return driverMap.get(id);
    }

    public void updateDriver(Driver driver) {
        driverMap.put(driver.id, driver);
    }

    public void deleteDriver(String id) {
        driverMap.remove(id);
    }

    public List<Driver> getDrivers(Location location, int raduis) {
        List<Driver> drivers = new ArrayList<>();
        for (Driver driver : driverMap.values()) {
            // System.out.println("driver: " + driver.name + " distance: " +
            // driver.currLocation.distanceTo(location));
            if (driver.currLocation.distanceTo(location) <= raduis && driver.isAvailable()) {
                drivers.add(driver);
            }
        }
        return drivers;
    }
}
