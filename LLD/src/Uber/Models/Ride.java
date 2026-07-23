package Uber.Models;

import Uber.Models.Products.Product;
import Uber.Enums.Status;

public class Ride {
    public String id;
    public Product product;
    public Location source;
    public Location destination;
    public Rider rider;
    public Driver driver;
    public Vehicle vehicle;
    public Status rideStatus;

    public Ride(Rider rider, Driver driver, Fare fare) {
        this.id = java.util.UUID.randomUUID().toString();
        this.rider = rider;
        this.driver = driver;
        this.product = fare.product;
        this.source = fare.source;
        this.destination = fare.destination;
        this.rideStatus = Status.START;
        this.vehicle = driver.vehicle;
    }

    public void startRide() {
        this.rideStatus = Status.ACTIVE;
    }

    public void endRide() {
        this.rideStatus = Status.COMPLETED;
        driver.makeAvailable();
    }

    @Override
    public String toString(){
        return "[ id: " + id +", Rider: " + rider.name + ", driver: " + 
        driver.name + ", product: " + product.productType.name() + ", source: " + source + ", destination: " + destination + 
        ", vehicle: " + vehicle.number + "]";
    }

}
