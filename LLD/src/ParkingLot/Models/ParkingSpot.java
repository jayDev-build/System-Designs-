package ParkingLot.Models;

import ParkingLot.Enums.VehicleType;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private String id;
    private AtomicBoolean occupied = new AtomicBoolean(false);
    private VehicleType allowedType;

    public ParkingSpot(String id, VehicleType allowedType){
        this.id = id;
        this.allowedType = allowedType;
    }

    public VehicleType getAllowedType(){
        return allowedType;
    }

    public boolean tryOccupy(){
        return occupied.compareAndExchange(false, true);
    }

    public void vacate(){
        occupied.set(false);
    }
}
