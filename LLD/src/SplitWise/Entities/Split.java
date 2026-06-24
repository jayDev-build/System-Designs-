package SplitWise.Entities;

public class Split {
    private final User user;
    private double amount;

    public Split(User user, double amount){
        this.user = user;
        this.amount = amount;
    }

    public double getAmount() {
        return this.amount;
    }

    public User getUser(){
        return this.user;
    }
}
