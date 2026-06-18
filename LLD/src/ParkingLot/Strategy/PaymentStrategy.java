package ParkingLot.Strategy;

import ParkingLot.Models.Ticket;

public abstract class PaymentStrategy {
    public abstract boolean pay(Ticket ticket, Double amount);
}
