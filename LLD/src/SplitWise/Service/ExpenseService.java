package SplitWise.Service;

import SplitWise.Entities.Expense;
import SplitWise.Entities.Group;
import SplitWise.Entities.Split;
import SplitWise.Entities.User;
import SplitWise.Enums.SplitType;
import SplitWise.Factory.EqualSplitStrategyFactory;
import SplitWise.Factory.PercentageSplitStrategyFactory;
import SplitWise.Factory.SplitStrategyFactory;
import SplitWise.Repository.InMemoryRepo;
import SplitWise.Strategy.SplitStrategy;

import java.util.List;
import java.util.Map;

public class ExpenseService {

    private final InMemoryRepo inMemoryRepo;
    private final BalanceSheetService balanceSheetService;

    public ExpenseService(InMemoryRepo inMemoryRepo, BalanceSheetService balanceSheetService){
        this.inMemoryRepo = inMemoryRepo;
        this.balanceSheetService = balanceSheetService;
    }

    public void addExpense(Group group,
                           String description,
                           double amount,
                           User paidBy,
                           List<User> participants,
                           SplitType splitType,
                           Map<User, Double> metaData){

        SplitStrategyFactory factory = switch (splitType){
            case SplitType.EQUAL -> new EqualSplitStrategyFactory();
            case SplitType.PERCENTAGE -> new PercentageSplitStrategyFactory();
        };

        SplitStrategy splitStrategy = factory.createSplitStrategy();
        List<Split> splitList = splitStrategy.split(amount, participants, metaData);

        Expense expense = new Expense();
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setSplitList(splitList);
        expense.setPaidBy(paidBy);
        group.addExpense(expense);

        balanceSheetService.updateBalances(group, splitList, paidBy);
    }
}
