package Uber.Service;

import Uber.Repository.RiderRepository;
import Uber.Models.Rider;

public class RiderService {
    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public void registerRider(Rider rider) {
        riderRepository.saveRider(rider);
    }

    public Rider getRiderById(String riderId) {
        Rider rider = riderRepository.getRider(riderId);
        if (rider == null) {
            throw new RuntimeException("Rider Not Found With ID: " + riderId);
        }

        return rider;
    }
}
