package ParkingLot.Models.Gate;

import ParkingLot.Enums.GateType;
import ParkingLot.Service.ParkingLot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle;

import java.time.LocalTime;

public class EntryGate extends Gate {

    public EntryGate(String id){
        super(id);
    }

    @Override
    public GateType getType() {
        return GateType.ENTRY;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalTime entryTime){
        return ParkingLot.getInstance().parkVehicle(vehicle, entryTime);
    }


}
