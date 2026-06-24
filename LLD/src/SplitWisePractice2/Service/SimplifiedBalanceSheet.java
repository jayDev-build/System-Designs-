package SplitWisePractice2.Service;

import SplitWisePractice2.Entities.BalanceSheet;
import SplitWisePractice2.Entities.Group;
import SplitWisePractice2.Entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SimplifiedBalanceSheet {

    public void simplifyBalanceSheet(Group group){
        HashMap<User, BalanceSheet> sheets = group.getBalanceSheetHashMap();
        Map<User, Double> netBalance = new HashMap<>();

        for (Map.Entry<User, BalanceSheet> entry : sheets.entrySet()){
            double val = entry.getValue().getBalances().values().stream().mapToDouble(v -> v).sum();
            netBalance.put(entry.getKey(), val);
            sheets.get(entry.getKey()).clearBalance();
        }

        PriorityQueue<User> creditors = new PriorityQueue<>((a, b) -> Double.compare(netBalance.get(b), netBalance.get(a)));
        PriorityQueue<User> debtors = new PriorityQueue<>((a, b) -> Double.compare(netBalance.get(a), netBalance.get(b)));

        netBalance.forEach((user, val) -> {
            if(val > 0) creditors.add(user);
            else debtors.add(user);
        });

        while (!creditors.isEmpty() && !debtors.isEmpty()){
            User creditor = creditors.poll();
            User debtor = debtors.poll();

            double creditAmount = netBalance.get(creditor);
            double debitAmount = netBalance.get(debtor);

            double settledAmount = Math.min(creditAmount, -debitAmount);

            sheets.get(creditor).addBalance(debtor, settledAmount);
            sheets.get(debtor).addBalance(creditor, -settledAmount);

            netBalance.put(creditor, creditAmount - settledAmount);
            netBalance.put(debtor, debitAmount + settledAmount);

            if(netBalance.get(creditor) > 0) creditors.add(creditor);
            if(netBalance.get(debtor) < 0) debtors.add(debtor);
        }

    }
}
