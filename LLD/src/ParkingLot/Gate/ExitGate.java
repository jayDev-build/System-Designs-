package ParkingLot.Gate;

import ParkingLot.Enums.GateType;
import ParkingLot.Strategy.PaymentStrategy;

import java.time.LocalDateTime;

public class ExitGate extends Gate {

    public ExitGate(String id) {
        super(id);
    }


    @Override
    public GateType getType() {
        return GateType.EXIT;
    }

    public void unParkVehicle(String ticketId, LocalDateTime exitTime, PaymentStrategy paymentStrategy){

    }
}
