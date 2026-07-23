package Uber;

import Uber.Models.Products.Product;
import Uber.Models.Driver;
import Uber.Models.Location;
import Uber.Models.Ride;
import Uber.Models.Rider;
import Uber.Models.Fare;
import Uber.Repository.DriverRepository;
import Uber.Repository.RideRepository;
import Uber.Repository.FareRepository;
import Uber.Repository.RiderRepository;
import Uber.Service.DriverMatchingService;
import Uber.Service.FareEstimationService;
import Uber.Service.RideService;
import Uber.Strategy.DriverMatching.DriverLocationStrategy;
import Uber.Strategy.DriverMatching.DriverMatchingStrategy;
import Uber.Enums.PricingStrategyType;
import Uber.Enums.ProductType;

import java.util.Map;
import java.util.Set;

import Uber.Models.Vehicle;
import Uber.Strategy.Pricing.PricingStrategy;
import Uber.Factory.PricingFactory;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        DriverRepository driverRepository = new DriverRepository();
        RiderRepository riderRepository = new RiderRepository();
        RideRepository rideRepository = new RideRepository();
        FareRepository fareRepository = new FareRepository();

        PricingFactory pricingFactory = new PricingFactory();
        PricingStrategy pricingStrategy = pricingFactory.createPricingStrategy(PricingStrategyType.LOCATION_BASED);

        DriverMatchingStrategy driverMatchingStrategy = new DriverLocationStrategy();

        FareEstimationService fareEstimationService = new FareEstimationService(fareRepository, pricingStrategy);
        DriverMatchingService driverMatchingService = new DriverMatchingService(driverRepository,
                driverMatchingStrategy);
        RideService rideService = new RideService(rideRepository, fareRepository, driverMatchingService);

        Vehicle vehicle1 = new Vehicle("ABC1234");
        vehicle1.addProduct(ProductType.UBER_GO);
        vehicle1.addProduct(ProductType.UBER_AUTO);
        Driver driver1 = new Driver("A", new Location(2, 2), vehicle1, 4.5);

        Vehicle vehicle2 = new Vehicle("ABC1234");
        vehicle2.addProduct(ProductType.UBER_GO);
        vehicle2.addProduct(ProductType.UBER_X);
        Driver driver2 = new Driver("B", new Location(3, 2), vehicle2, 3.9);

        Vehicle vehicle3 = new Vehicle("ABC1234");
        vehicle3.addProduct(ProductType.UBER_AUTO);
        vehicle3.addProduct(ProductType.UBER_AUTO);
        Driver driver3 = new Driver("C", new Location(3, 3), vehicle3, 4.2);

        driverRepository.saveDriver(driver1);
        driverRepository.saveDriver(driver2);
        driverRepository.saveDriver(driver3);

        Location start = new Location(1, 1);
        Location destination = new Location(5, 5);

        Rider rider = new Rider("1", "Rider1", start);
        riderRepository.saveRider(rider);

        // Estimated Fares
        System.out.println("Getting Fare Estimates for trip Start: " + start.toString() + " Destiantion: "
                + destination.toString());
        HashSet<ProductType> productList = new HashSet<>(
                Set.of(ProductType.UBER_AUTO, ProductType.UBER_GO, ProductType.UBER_X));
        Map<Product, Double> estimates = fareEstimationService.getFareEstimates(productList, start, destination);
        estimates.forEach(
                (prod, price) -> System.out.println("product type: " + prod.productType.name() + " price: " + price));

        // Booking within TTL
        System.out.println("\nRequesting Ride booking: ");
        Fare fare = fareEstimationService.creteFare(rider.id, ProductType.UBER_GO, start, destination);
        System.out.println("Fare Created: " + fare.toString());

        try {
            Ride ride = rideService.requestRide(fare.id, rider);
            ride.startRide();
            System.out.println("Ride booked successfully: " + ride.toString());
        } catch (Exception e) {
            System.out.println("Ride Booking failed: " + e.getMessage());
        }

        // Booking after TTL
        System.out.println("\nRequesting Ride booking after TTL: ");
        Fare fare2 = fareEstimationService.creteFare(rider.id, ProductType.UBER_AUTO, new Location(3, 2), destination);
        System.out.println("Fare Created: " + fare2.toString());

        try {
            Thread.sleep(6000);
            Ride ride = rideService.requestRide(fare2.id, rider);
            ride.startRide();
            System.out.println("Ride booked successfully: " + ride.toString());
        } catch (Exception e) {
            System.out.println("Ride Booking failed: " + e.getMessage());
        }

    }
}
