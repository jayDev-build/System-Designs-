package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Factory.VehicleFactory;

import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {
    public String id;
    public ConcurrentHashMap<String, ParkingSpot> spots;

    public ParkingFloor(String id){
        this.id = id;
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType){
        for(String spotId : spots.keySet()){
            ParkingSpot spot = spots.get(spotId);
            if(spot.tryOccupy() && spot.getAllowedType().equals(vehicleType)) return spot;
        }

        return null;
    }

    public ParkingSpot getSpot(String id){
        return spots.get(id);
    }
}
