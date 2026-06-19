package ParkingLot.Factory;

import ParkingLot.Enums.GateType;
import ParkingLot.Models.Gate.EntryGate;
import ParkingLot.Models.Gate.ExitGate;
import ParkingLot.Models.Gate.Gate;

public class GateFactory {
    public Gate createGate(GateType gateType, String id){
        return switch (gateType){
            case EXIT -> new ExitGate(id);
            case ENTRY -> new EntryGate(id);
        };
    }
}
