package ParkingLot.Strategy.Payment;

import ParkingLot.Models.Ticket;

public abstract class PaymentStrategy {
    public abstract boolean pay(Ticket ticket, Double amount);
}
