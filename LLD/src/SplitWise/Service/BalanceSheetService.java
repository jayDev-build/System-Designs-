package SplitWise.Service;

import SplitWise.Entities.BalanceSheet;
import SplitWise.Entities.Group;
import SplitWise.Entities.Split;
import SplitWise.Entities.User;

import java.util.List;

public class BalanceSheetService {

    public void updateBalances(Group group, List<Split> splitList, User paidBy){
        double totalAmount = splitList.stream().mapToDouble(Split::getAmount).sum();
        group.getBalanceSheet(paidBy).addAmountPaid(totalAmount);

        for (Split split : splitList) {
            User user = split.getUser();
            double amount = split.getAmount();
            group.getBalanceSheet(user).addTotalExpense(amount);

            if (!user.equals(paidBy)) {
                group.getBalanceSheet(user).addBalance(paidBy, -amount);
                group.getBalanceSheet(paidBy).addBalance(user, amount);
            }
        }
    }

    public void printBalanceSheet(Group group){
        List<User> userList = group.getUserList();
        userList.forEach(user -> {
            BalanceSheet sheet = group.getBalanceSheet(user);

            double owe = 0;
            double receive = 0;

            for(double val : sheet.balances.values()){
                if(val < 0) owe += val;
                else receive += val;
            }

            System.out.printf("""
                    💵 %s
                       Paid: %.2f  Expense: %.2f
                       You owe: %.2f, You get: %.2f%n
                    """,
                    user.name, sheet.amountPaid, sheet.totalExpense, owe, receive);

            sheet.balances.forEach((other, val) -> {
                        System.out.printf(
                                "  %s %.2f %s%n",
                                val > 0 ? "← get" : "→ owe",
                                Math.abs(val),
                                other.name);
                        System.out.println("--------------------------");
                    }
            );

        });
    }
}
