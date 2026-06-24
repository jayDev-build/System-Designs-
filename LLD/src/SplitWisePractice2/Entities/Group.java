package SplitWisePractice2.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<User> members;
    private List<Expense> expenseList;
    private HashMap<User, BalanceSheet> balanceSheetHashMap;

    public Group(String id, String name){
        this.id = id;
        this.name = name;
        balanceSheetHashMap = new HashMap<>();
        expenseList = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addMember(User member){
        members.add(member);
        balanceSheetHashMap.putIfAbsent(member, new BalanceSheet());
    }

    public void addExpense(Expense expense){
        expenseList.add(expense);
    }

    public HashMap<User, BalanceSheet> getBalanceSheetHashMap(){
        return this.balanceSheetHashMap;
    }
}
