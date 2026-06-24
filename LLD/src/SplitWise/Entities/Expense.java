package SplitWise.Entities;

import SplitWise.Enums.SplitType;

import java.util.List;

public class Expense {
    public String description;
    private List<Split> splitList;
    private double amount;
    private User paidBy;
    private SplitType splitType;


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }


    public void setSplitList(List<Split> splitList) {
        this.splitList = splitList;
    }


    public void setDescription(String description) {
        this.description = description;
    }
}
