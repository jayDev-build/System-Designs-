package SplitWise.Service;

import SplitWise.Entities.*;
import SplitWise.Enums.SplitType;
import SplitWise.Repository.InMemoryRepo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class GroupService {

    private final InMemoryRepo inMemoryRepo;
    private final ExpenseService expenseService;
    private final BalanceSheetService balanceSheetService;
    private final SimplifiedBalanceSheet simplifiedBalanceSheet;

    public GroupService(InMemoryRepo inMemoryRepo, ExpenseService expenseService, BalanceSheetService balanceSheetService, SimplifiedBalanceSheet simplifiedBalanceSheet){
        this.inMemoryRepo = inMemoryRepo;
        this.expenseService = expenseService;
        this.balanceSheetService = balanceSheetService;
        this.simplifiedBalanceSheet = simplifiedBalanceSheet;
    }

    public Group createGroup(String name){
        String id = UUID.randomUUID().toString();
        Group group = new Group(id, name);
        inMemoryRepo.addGroup(id, group);
        return group;
    }

    public void addMember(Group group, User user){
        group.addUser(user);
    }

    public void addExpense(Group group,
                           String description,
                           double amount,
                           User paidBy,
                           List<User> participants,
                           SplitType splitType,
                           Map<User, Double> metaData){
        expenseService.addExpense(group, description, amount, paidBy, participants, splitType, metaData);
    }

    public void simplifyBalances(Group group){
        simplifiedBalanceSheet.simplifyBalanceSheet(group);
    }

    public void printBalances(Group group){
        balanceSheetService.printBalanceSheet(group);
    }

}
