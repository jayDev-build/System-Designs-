package SplitWisePractice2.Service;

import SplitWise.Enums.SplitType;
import SplitWisePractice2.Entities.Expense;
import SplitWisePractice2.Entities.Group;
import SplitWisePractice2.Entities.User;
import SplitWisePractice2.Enums.SplitStrategyType;
import SplitWisePractice2.Repository.InMemoryRepo;
import SplitWisePractice2.Strategy.SplitStrategy;

import java.util.List;
import java.util.Map;


public class GroupService {

    private final InMemoryRepo repo;
    private final ExpenseService expenseService;
    private final BalanceSheetService balanceSheetService;

    public GroupService(InMemoryRepo inMemoryRepo, ExpenseService expenseService, BalanceSheetService balanceSheetService){
        this.repo = inMemoryRepo;
        this.expenseService = expenseService;
        this.balanceSheetService = balanceSheetService;
    }

    public Group createGroup(String id, String name){
        Group group = new Group(id, name);
        repo.addGroup(id, group);
        return group;
    }

    public Group getGroup(String groupId){
        return repo.getGroup(groupId);
    }

    public void addExpense(Group group, String description, double amount, User paidBy, List<User> participants,
                           Map<User, Double> metaData, SplitStrategyType splitType){
        expenseService.addExpense(group, description, amount, paidBy, participants, metaData, splitType);
    }

    public void printBalance(Group group) {
        balanceSheetService.printBalanceSheet(group);
    }
}
