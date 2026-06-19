package ParkingLot.Models.Gate;

import ParkingLot.Enums.GateType;

public abstract class Gate {
    private String id;

    public Gate(String id) {
        this.id = id;
    }

    public abstract GateType getType();
}
