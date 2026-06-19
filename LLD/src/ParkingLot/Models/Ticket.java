package ParkingLot.Models;

import ParkingLot.Enums.PaymentStatus;
import ParkingLot.Strategy.PaymentStrategy;
import ParkingLot.Vehicle.Vehicle;

import java.time.LocalTime;

public class Ticket {
    public String id;
    private LocalTime entryTime;
    public String floorId;
    public String spotId;
    private Vehicle vehicle;
    private PaymentStrategy paymentStrategy;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Ticket(){};

    public Ticket(String id, LocalTime entryTime, String floorId, String spotId, Vehicle vehicle, PaymentStrategy paymentStrategy){
        this.id = id;
        this.entryTime = entryTime;
        this.floorId = floorId;
        this.spotId = spotId;
        this.vehicle = vehicle;
        this.paymentStrategy = paymentStrategy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


}
