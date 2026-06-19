package ParkingLot.Service;

import ParkingLot.Enums.PaymentType;
import ParkingLot.Enums.PricingStrategyType;
import ParkingLot.Factory.PaymentFactory;
import ParkingLot.Factory.PricingStrategyFactory;
import ParkingLot.Models.Parking.ParkingFloor;
import ParkingLot.Models.Parking.ParkingSpot;
import ParkingLot.Models.Ticket;
import ParkingLot.Models.Vehicle.Vehicle;
import ParkingLot.Strategy.Payment.PaymentStrategy;
import ParkingLot.Strategy.Pricing.PricingStrategy;

import java.time.LocalTime;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;


    private ConcurrentHashMap<String, ParkingFloor> floors;
    private ConcurrentHashMap<String, Ticket> activeTickets;

    private PricingStrategyFactory pricingStrategyFactory ;
    private PricingStrategy pricingStrategy ;

    //private constructor
    private ParkingLot(){
        pricingStrategyFactory = new PricingStrategyFactory();
        pricingStrategy = pricingStrategyFactory.get(PricingStrategyType.TIMEBASEPRICING);
        floors = new ConcurrentHashMap<>();
        activeTickets = new ConcurrentHashMap<>();
    }

    public static ParkingLot getInstance(){
        if(instance == null){
            synchronized (ParkingLot.class){
                if(instance == null){
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor parkingFloor){
        floors.put(parkingFloor.id, parkingFloor);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalTime entryTime){
        ParkingSpot spot;
        for(ParkingFloor floor : floors.values()){
            spot = floor.findAvailableSpot(vehicle.getType());
            if(spot != null && spot.tryOccupy()){
                Ticket ticket = new Ticket();
                UUID uuid = UUID.randomUUID();
                ticket.setId(uuid.toString());
                ticket.setEntryTime(entryTime);
                ticket.setVehicle(vehicle);
                ticket.setSpotId(spot.id);
                ticket.setFloorId(floor.id);

                activeTickets.put(uuid.toString(), ticket);
                System.out.println("Vehicle Parked Ticket: " + ticket);
                return ticket;
            }
        }

        System.out.println("No spot available for vehicle type: " + vehicle.getType());
        return null;
    }

    public void unParkVehicle(String ticketId, LocalTime exitTime, PaymentType paymentType){
        Ticket ticket = activeTickets.get(ticketId);
        if(ticket == null){
            throw new  IllegalArgumentException("Invalid Ticket Id");
        }
        Double totalCost = pricingStrategy.calculate(ticket.getVehicle().getType(), ticket.getEntryTime(), exitTime);

        PaymentFactory paymentFactory = new PaymentFactory();
        PaymentStrategy paymentStrategy = paymentFactory.getPaymentStrategy(paymentType);

        PaymentProcessor paymentProcessor = new PaymentProcessor(paymentStrategy);
        boolean paid = paymentProcessor.pay(ticket, totalCost);

        if(!paid){
            System.out.println("Vehicle cannot exit. Payment unsuccessful.");
            return;
        }

        ParkingSpot parkingSpot = floors.get(ticket.floorId).getSpot(ticket.spotId);
        parkingSpot.vacate();
        activeTickets.remove(ticketId);

        System.out.println("Vehicle exited. Fee charged: ₹" + totalCost);
    }

    public void printStatus() {
        floors.forEach((floorId, floor) -> {
            System.out.println("Floor Id: " + floorId);
            floor.spots.forEach((spotId, spot) -> {
                System.out.println("spotId: " + spotId + " [" + spot.getAllowedType() + "] - " + (spot.isOccupied() ? "Occupied" : "Free"));
            });
        });
    }


}
