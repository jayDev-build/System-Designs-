package Uber.Repository;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import Uber.Models.Fare;

public class FareRepository {

    public static class FareEntry {
        public String riderId;
        public Fare fare;

        public FareEntry(String riderId, Fare fare) {
            this.riderId = riderId;
            this.fare = fare;
        }
    }

    Map<String, FareEntry> fareMap;

    public FareRepository() {
        this.fareMap = new HashMap<>();
    }

    public void save(String riderId, Fare fare) {
        fareMap.put(fare.id, new FareEntry(riderId, fare));
    }

    public Fare findById(String id) {
        FareEntry entry = fareMap.get(id);
        if (entry == null) {
            return null;
        }

        if (entry.fare.createdAt.isBefore(Instant.now().minusSeconds(5L))) {
            delete(id);
            return null;
        }
        return entry.fare;
    }

    public void delete(String id) {
        fareMap.remove(id);
    }
}
