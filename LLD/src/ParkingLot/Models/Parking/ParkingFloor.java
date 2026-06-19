package ParkingLot.Models.Parking;

import ParkingLot.Enums.VehicleType;

import java.util.concurrent.ConcurrentHashMap;

public class ParkingFloor {
    public String id;
    public ConcurrentHashMap<String, ParkingSpot> spots;

    public ParkingFloor(String id){
        this.id = id;
        spots = new ConcurrentHashMap<>();
    }

    public ParkingSpot findAvailableSpot(VehicleType vehicleType){
        for(String spotId : spots.keySet()){
            ParkingSpot spot = spots.get(spotId);
            if(!spot.isOccupied() && spot.getAllowedType().equals(vehicleType)) return spot;
        }

        return null;
    }

    public ParkingSpot getSpot(String id){
        return spots.get(id);
    }

    public void addParkingSpot(ParkingSpot parkingSpot){
        spots.put(parkingSpot.id, parkingSpot);
    }
}
