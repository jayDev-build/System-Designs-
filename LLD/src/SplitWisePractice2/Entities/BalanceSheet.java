package SplitWisePractice2.Entities;

import java.util.HashMap;

public class BalanceSheet {

    private double totalExpense;
    private double amountPaid;
    private HashMap<User, Double> balances;

    public BalanceSheet(){
        totalExpense = 0d;
        amountPaid = 0d;
        balances = new HashMap<>();
    }

    public HashMap<User, Double> getBalances(){
        return this.balances;
    }

    public void addBalance(User other, double amount){
        balances.put(other, balances.getOrDefault(other, 0d) + amount);
        if(Math.abs(balances.get(other)) < 1e-6) balances.remove(other);
    }

    public double getBalance(User other){
        return balances.getOrDefault(other, 0d);
    }

    public double getTotalExpense(){
        return this.totalExpense;
    }

    public double getAmountPaid(){
        return this.amountPaid;
    }

    public void addExpense(double expense){
        this.totalExpense += expense;
    }

    public void addPaid(double amount){
        this.amountPaid += amount;
    }

    public void clearBalance() {
        balances.clear();
    }
}
