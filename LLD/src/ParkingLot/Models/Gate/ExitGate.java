package ParkingLot.Models.Gate;

import ParkingLot.Enums.GateType;
import ParkingLot.Enums.PaymentType;
import ParkingLot.Service.ParkingLot;

import java.time.LocalTime;

public class ExitGate extends Gate {

    public ExitGate(String id) {
        super(id);
    }


    @Override
    public GateType getType() {
        return GateType.EXIT;
    }

    public void unParkVehicle(String ticketId, LocalTime exitTime, PaymentType paymentType){
        ParkingLot.getInstance().unParkVehicle(ticketId, exitTime, paymentType);
    }
}
