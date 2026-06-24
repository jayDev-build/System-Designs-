package SplitWisePractice2.Entities;

public class Split {
    private User user;
    private double amount;

    public Split(User user, double amount){
        this.amount = amount;
        this.user = user;
    }

    public double getAmount(){
        return this.amount;
    }

    public User getUser() {
        return user;
    }
}
