package SplitWise.Service;

import SplitWise.Entities.BalanceSheet;
import SplitWise.Entities.Group;
import SplitWise.Entities.User;

import java.util.*;

public class SimplifiedBalanceSheet {

    public void simplifyBalanceSheet(Group group){
        List<User> users = new ArrayList<>(group.getUserList());
        Map<User, BalanceSheet> sheets = group.getBalanceSheets();
        HashMap<User, Double> netBalances = new HashMap<>();

        for(User user : users){
            double net = 0.0;
            Map<User, Double> balances = sheets.get(user).getBalances();
            for (double amount : balances.values()) {
                net += amount;
            }
            netBalances.put(user, net);
            sheets.get(user).clearBalances();
        }

        PriorityQueue<User> creditors = new PriorityQueue<>((a, b) -> Double.compare(netBalances.get(b), netBalances.get(a)));
        PriorityQueue<User> debtors = new PriorityQueue<>((a, b) -> Double.compare(netBalances.get(a), netBalances.get(b)));

        for (User user : users) {
            double net = netBalances.get(user);
            if (net > 0) {
                creditors.offer(user);
            } else if (net < 0) {
                debtors.offer(user);
            }
        }

        while (!creditors.isEmpty() && !debtors.isEmpty()) {
            User creditor = creditors.poll();
            User debtor = debtors.poll();

            double creditAmount = netBalances.get(creditor);
            double debitAmount = netBalances.get(debtor);

            double settledAmount = Math.min(creditAmount, -debitAmount);

            // Update balances both sides
            group.getBalanceSheet(creditor).addBalance(debtor, settledAmount);
            group.getBalanceSheet(debtor).addBalance(creditor, -settledAmount);

            // Update net balances after settlement
            netBalances.put(creditor, creditAmount - settledAmount);
            netBalances.put(debtor, debitAmount + settledAmount);

            // If still unsettled, re-add to queues
            if (netBalances.get(creditor) > 0) {
                creditors.offer(creditor);
            }
            if (netBalances.get(debtor) < 0) {
                debtors.offer(debtor);
            }
        }
    }
}
