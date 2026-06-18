package ParkingLot.Factory;

import ParkingLot.Enums.GateType;
import ParkingLot.Gate.EntryGate;
import ParkingLot.Gate.ExitGate;
import ParkingLot.Gate.Gate;

public class GateFactory {
    public Gate createGate(GateType gateType, String id){
        return switch (gateType){
            case EXIT -> new ExitGate(id);
            case ENTRY -> new EntryGate(id);
        };
    }
}
