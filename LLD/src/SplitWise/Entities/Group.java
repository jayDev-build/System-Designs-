package SplitWise.Entities;

import SplitWise.Enums.SplitType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private String id;
    public String name;
    private List<User> userList;
    private List<Expense> expenseList;
    private Map<User, BalanceSheet> balanceSheetMap;


    public Group(String id,String name){
        this.id = id;
        this.name = name;
        userList = new ArrayList<>();
        expenseList = new ArrayList<>();
        balanceSheetMap = new HashMap<>();
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void addExpense(Expense expense) {
        expenseList.add(expense);
    }

    public void addUser(User user){
        userList.add(user);
        balanceSheetMap.putIfAbsent(user, new BalanceSheet());
    }

    public List<User> getUserList(){
        return userList;
    }

    public BalanceSheet getBalanceSheet(User user){
        return balanceSheetMap.get(user);
    }

    public Map<User, BalanceSheet> getBalanceSheets() {
        return balanceSheetMap;
    }
}
