package SplitWisePractice2.Service;

import SplitWisePractice2.Entities.Expense;
import SplitWisePractice2.Entities.Group;
import SplitWisePractice2.Entities.Split;
import SplitWisePractice2.Entities.User;
import SplitWisePractice2.Enums.SplitStrategyType;
import SplitWisePractice2.Factory.SplitStrategyFactory;
import SplitWisePractice2.Strategy.SplitStrategy;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    private final SplitStrategyFactory factory;
    private final BalanceSheetService balanceSheetService;

    public ExpenseService(BalanceSheetService balanceSheetService){
        factory = new SplitStrategyFactory();
        this.balanceSheetService = balanceSheetService;
    }

    public void addExpense(Group group, String description, double amount, User paidBy, List<User> participants, Map<User, Double> metaData, SplitStrategyType type){
        SplitStrategy strategy = factory.createSplitStrategy(type);
        List<Split> splitList = strategy.split(amount, participants, metaData);

        Expense expense = new Expense(
                description,
                amount,
                paidBy,
                splitList
        );

        group.addExpense(expense);

        balanceSheetService.updateBalance(group, paidBy, splitList);

    }
}
