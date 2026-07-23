package Uber.Models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class Driver {
    public String id;
    public String name;
    public Location currLocation;
    public Vehicle vehicle;
    public Double rating;

    public AtomicBoolean available = new AtomicBoolean(true);

    public Driver(String name, Location currLocation, Vehicle vehicle, Double rating) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.currLocation = currLocation;
        this.vehicle = vehicle;
        this.rating = rating;
    }

    public boolean makeUnavailable() {
        return this.available.compareAndSet(true, false);
    }

    public boolean makeAvailable() {
        return this.available.compareAndSet(false, true);
    }

    public boolean isAvailable() {
        return this.available.get();
    }

    public void setCurrentLocation(Location newLocation) {
        this.currLocation = newLocation;
    }
}
