package ParkingLot.Models;

import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private ParkingLot instance;

    private ParkingLot(){}   //private constructor

    private ConcurrentHashMap<String, ParkingFloor> floors;
    private ConcurrentHashMap<String, Ticket> activeTickets;

    public ParkingLot getInstance(){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null){
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addFloor(String id){
        ParkingFloor floor = new ParkingFloor(id);
        floors.put(id, floor);
    }

    public Ticket parkVehicle(){


        return new Ticket();
    }

    public void unParkVehicle(){

        
    }


}
