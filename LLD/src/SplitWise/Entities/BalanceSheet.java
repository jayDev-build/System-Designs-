package SplitWise.Entities;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    public double amountPaid;
    public double totalExpense;
    public Map<User, Double> balances = new HashMap<>();

    BalanceSheet(){
        amountPaid = 0;
        totalExpense = 0;
    }

    public void addAmountPaid(double amount){
        amountPaid += amount;
    }

    public void addTotalExpense(double amount){
        totalExpense += amount;
    }

    public double getBalance(){
        return amountPaid - totalExpense;
    }
    public void addBalance(User other, double amount){
        balances.put(other, balances.getOrDefault(other, 0d) + amount);
        if(Math.abs(balances.get(other)) < 1e-6) balances.remove(other);
    }

    public void clearBalances() {
        balances.clear();
    }

    public void printBalance(User me){
        double amountOwe = 0;
        double amountToReceive = 0;

        for(double amount : balances.values()){
            if(amount < 0) amountOwe += amount;
            else amountToReceive += amount;
        }
        System.out.println("💵 Balance sheet of : " + me.name);
        System.out.println("Total You Paid : " + amountPaid);
        System.out.println("Total Expense : " + totalExpense);
        System.out.println("Total You Owe : " + amountOwe);
        System.out.println("Total You Get Back : " + amountToReceive);

        for(Map.Entry<User, Double> entry : balances.entrySet()){
            if(entry.getValue() < 0){
                System.out.println(me.name + " owes " + Math.abs(entry.getValue()) + " to " + entry.getKey().name);
            }else{
                System.out.println(me.name + " will receive " + Math.abs(entry.getValue()) + " from " + entry.getKey().name);
            }
        }

        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
    }

    public Map<User, Double> getBalances() {
        return this.balances;
    }
}
