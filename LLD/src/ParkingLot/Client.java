package ParkingLot;

import ParkingLot.Enums.VehicleType;
import ParkingLot.Factory.VehicleFactory;
import ParkingLot.Models.Gate.EntryGate;
import ParkingLot.Models.Gate.ExitGate;
import ParkingLot.Models.ParkingFloor;
import ParkingLot.Service.ParkingLot;
import ParkingLot.Models.ParkingSpot;

import ParkingLot.Models.Vehicle;

import java.time.LocalTime;

public class Client {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        EntryGate entryGate = new EntryGate("1");
        ExitGate exitGate = new ExitGate("2");

        ParkingFloor parkingFloor1 = new ParkingFloor("1");
        parkingFloor1.addParkingSpot(new ParkingSpot("F1S1", VehicleType.BIKE));
        parkingFloor1.addParkingSpot(new ParkingSpot("F1S2", VehicleType.CAR));
        parkingFloor1.addParkingSpot(new ParkingSpot("F1S3", VehicleType.TRUCK));
//        parkingFloor1.addParkingSpot(new ParkingSpot("F1S4", VehicleType.CAR));

        parkingLot.addFloor(parkingFloor1);

        System.out.println("--------------------------");

        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle car1 = vehicleFactory.createVehicle(VehicleType.CAR, "KA01AB1234");
        Vehicle car2 = vehicleFactory.createVehicle(VehicleType.CAR, "KA01AB5678");

        LocalTime entryTime = LocalTime.now().minusHours(3);
//        Ticket ticket = entryGate.parkVehicle(car1, entryTime);
//
//        System.out.println("--------------------------");
//
//        parkingLot.printStatus();
//
//        LocalTime exitTime = LocalTime.now().plusHours(5);
//        exitGate.unParkVehicle(ticket.id, exitTime, PaymentType.CARD);
//
//        System.out.println("--------------------------");
//
//        parkingLot.printStatus();

        Thread t1 = new Thread(() -> entryGate.parkVehicle(car1, entryTime));
        Thread t2 = new Thread(() -> entryGate.parkVehicle(car2, entryTime));

        t1.start();
        t2.start();
    }
}
