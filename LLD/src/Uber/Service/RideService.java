package Uber.Service;


import Uber.Repository.FareRepository;
import Uber.Repository.RideRepository;
import Uber.Models.Rider;
import Uber.Models.Driver;
import Uber.Models.Fare;
import Uber.Models.Ride;

public class RideService {
    private final RideRepository rideRepository;
    private final FareRepository fareRepository;
    private final DriverMatchingService driverMatchingService;

    public RideService(RideRepository rideRepository, FareRepository fareRepository,
            DriverMatchingService driverMatchingService) {
        this.rideRepository = rideRepository;
        this.fareRepository = fareRepository;
        this.driverMatchingService = driverMatchingService;
    }

    public Ride requestRide(String fareId, Rider rider) {
        Fare fare = fareRepository.findById(fareId);

        if (fare == null) {
            throw new RuntimeException("No Fare Available with fareID: " + fareId);
        }

        Driver driver = driverMatchingService.findNearestAvailableDriver(fare.source, fare.product.productType);

        if (driver == null) {
            throw new RuntimeException("No Driver Available");
        }

        Ride ride = new Ride(rider, driver, fare);
        driver.makeUnavailable();

        rideRepository.save(ride);
        return ride;
    }

    public void endRide(Ride ride) {
        ride.endRide();
    }

}
