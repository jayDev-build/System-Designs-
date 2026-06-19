package ParkingLot.Strategy.Payment;

import ParkingLot.Models.Ticket;

public class CashPayment extends PaymentStrategy {
    @Override
    public boolean pay(Ticket ticket, Double amount) {
        System.out.println("Paying Amount "+ amount + " for ticket id: " + ticket.getId() + " Via Cash ..........");
        return true;
    }
}
