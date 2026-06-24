package SplitWise;

import SplitWise.Entities.Group;
import SplitWise.Entities.User;
import SplitWise.Enums.SplitType;
import SplitWise.Repository.InMemoryRepo;
import SplitWise.Service.BalanceSheetService;
import SplitWise.Service.ExpenseService;
import SplitWise.Service.GroupService;
import SplitWise.Service.SimplifiedBalanceSheet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User shubh = new User("u1", "Shubh");
        User bob   = new User("u2", "Bob");
        User tom   = new User("u3", "Tom");
        User jake  = new User("u4", "Jake");

        InMemoryRepo inMemoryRepo = new InMemoryRepo();
        BalanceSheetService balanceSheetService = new BalanceSheetService();
        ExpenseService expenseService = new ExpenseService(inMemoryRepo , balanceSheetService);
        SimplifiedBalanceSheet simplifiedBalanceSheet = new SimplifiedBalanceSheet();

        GroupService groupService = new GroupService(inMemoryRepo, expenseService, balanceSheetService,simplifiedBalanceSheet);
        Group group = groupService.createGroup("group1");

        groupService.addMember(group, shubh);
        groupService.addMember(group, bob);
        groupService.addMember(group, tom);
        groupService.addMember(group, jake);

        groupService.addExpense(group, "Lunch Day-1", 100, shubh,
                List.of(shubh, bob), SplitType.EQUAL, null);
        groupService.addExpense(group, "Lunch Day-2", 200, jake,
                List.of(shubh, bob, tom, jake), SplitType.EQUAL, null);

        groupService.printBalances(group);
        groupService.simplifyBalances(group);

        System.out.println("=============================");

        groupService.printBalances(group);
    }


}
