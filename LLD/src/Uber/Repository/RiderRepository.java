package Uber.Repository;

import java.util.HashMap;
import Uber.Models.Rider;

public class RiderRepository {
    HashMap<String, Rider> rideMap;

    public RiderRepository() {
        this.rideMap = new HashMap<>();
    }

    public void saveRider(Rider rider) {
        rideMap.put(rider.id, rider);
    }

    public Rider getRider(String id) {
        return rideMap.get(id);
    }

    public void deleteRider(String id) {
        rideMap.remove(id);
    }
}
