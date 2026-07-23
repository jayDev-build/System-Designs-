package Uber.Repository;

import java.util.HashMap;
import java.util.Map;

import Uber.Models.Ride;

public class RideRepository {
    private Map<String, Ride> rides = new HashMap<>();

    public void save(Ride ride) {
        rides.put(ride.id, ride);
    }

    public Ride findById(String id) {
        return rides.get(id);
    }
}
