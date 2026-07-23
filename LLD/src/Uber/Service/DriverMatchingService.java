package Uber.Service;

import Uber.Models.Location;
import Uber.Models.Products.Product;
import Uber.Repository.DriverRepository;
import Uber.Strategy.DriverMatching.DriverMatchingStrategy;
import Uber.Models.Driver;
import java.util.List;

public class DriverMatchingService {

    private final DriverRepository driverRepository;
    private final DriverMatchingStrategy driverMatchingStrategy;

    public DriverMatchingService(DriverRepository driverRepository, DriverMatchingStrategy driverMatchingStrategy) {
        this.driverRepository = driverRepository;
        this.driverMatchingStrategy = driverMatchingStrategy;
    }

    public Driver findNearestAvailableDriver(Location location, Product product) {
        List<Driver> nearestDrivers = driverRepository.getDrivers(location, 2);

        nearestDrivers = nearestDrivers.stream().filter(d -> d.vehicle.supportedProducts.contains(product)).toList();

        return driverMatchingStrategy.findDriver(location, nearestDrivers);
    }
}
