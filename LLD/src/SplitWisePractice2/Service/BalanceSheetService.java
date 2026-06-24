package SplitWisePractice2.Service;

import SplitWisePractice2.Entities.BalanceSheet;
import SplitWisePractice2.Entities.Group;
import SplitWisePractice2.Entities.Split;
import SplitWisePractice2.Entities.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceSheetService {

    public void updateBalance(Group group, User paidBy, List<Split> splitList){
        double totalAmount = splitList.stream().mapToDouble(Split::getAmount).sum();
        HashMap<User, BalanceSheet> balanceSheetHashMap = group.getBalanceSheetHashMap();
        balanceSheetHashMap.get(paidBy).addPaid(totalAmount);

        splitList.forEach(split -> {
            User user = split.getUser();
            double amount = split.getAmount();
            balanceSheetHashMap.get(user).addExpense(amount);

            if(!user.equals(paidBy)){
                balanceSheetHashMap.get(user).addBalance(paidBy, -amount);
                balanceSheetHashMap.get(paidBy).addBalance(user, amount);
            }
        });
    }

    public void printBalanceSheet(Group group){
        HashMap<User, BalanceSheet> balanceSheetHashMap = group.getBalanceSheetHashMap();
        for(Map.Entry<User, BalanceSheet> entry : balanceSheetHashMap.entrySet()){
            double owe = 0d; double receive = 0d;
            double totalExpense = entry.getValue().getTotalExpense();
            double totalPaid = entry.getValue().getAmountPaid();

            HashMap<User, Double> userBalances = entry.getValue().getBalances();
            for(Map.Entry<User, Double> subEntry : userBalances.entrySet()){
                double val = subEntry.getValue();
                if(val < 0) owe += val;
                else receive += val;
            }

            System.out.printf(""" 
                    %s balance sheet
                    Paid: %.2f  Expense: %.2f
                    You owe: %.2f, You get: %.2f%n
                    """, entry.getKey().getName(), totalPaid, totalExpense, owe, receive);


            userBalances.forEach((other, val) -> System.out.printf("  %s %.2f %s%n \n",
                    val > 0 ? "← get" : "→ owe",
                    Math.abs(val),
                    other.getName()));
        }
    }
}
