package SplitWisePractice2.Entities;

import DesignPatterns.FactoryMethod.Factory;
import SplitWisePractice2.Enums.SplitStrategyType;
import SplitWisePractice2.Factory.SplitStrategyFactory;
import SplitWisePractice2.Strategy.SplitStrategy;

import java.util.List;

public class Expense {
    private String description;
    private double amount;
    private User paidBy;
    private List<Split> splitList;

    public Expense(String description, double amount, User paidBy, List<Split> splitList){
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitList = splitList;
    }
}
