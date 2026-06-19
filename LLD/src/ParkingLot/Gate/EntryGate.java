package ParkingLot.Gate;

import ParkingLot.Enums.GateType;
import ParkingLot.Models.ParkingLot;
import ParkingLot.Models.Ticket;
import ParkingLot.Vehicle.Vehicle;

import java.time.LocalDateTime;
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
