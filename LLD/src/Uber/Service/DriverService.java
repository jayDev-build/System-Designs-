package Uber.Service;

import Uber.Repository.DriverRepository;
import Uber.Models.Driver;
import Uber.Models.Location;

public class DriverService {

    private DriverRepository driverRepository;

    DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void registerDriver(Driver driver) {
        driverRepository.saveDriver(driver);
    }

    public void updateLocation(String driverId, Location newLocation) {
        Driver driver = driverRepository.getDriver(driverId);
        if (driver == null) {
            throw new RuntimeException("Driver Not Found With ID: " + driverId);
        }

        driver.setCurrentLocation(newLocation);
    }

}
