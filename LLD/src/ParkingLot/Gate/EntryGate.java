package ParkingLot.Gate;

import ParkingLot.Enums.GateType;
import ParkingLot.Models.Ticket;
import Prototype.Vehicle;

import java.time.LocalDateTime;

public class EntryGate extends Gate {

    public EntryGate(String id){
        super(id);
    }

    @Override
    public GateType getType() {
        return GateType.ENTRY;
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return new Ticket();
    }


}
