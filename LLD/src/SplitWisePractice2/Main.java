package SplitWisePractice2;

import SplitWisePractice2.Entities.Group;
import SplitWisePractice2.Entities.User;
import SplitWisePractice2.Enums.SplitStrategyType;
import SplitWisePractice2.Repository.InMemoryRepo;
import SplitWisePractice2.Service.BalanceSheetService;
import SplitWisePractice2.Service.ExpenseService;
import SplitWisePractice2.Service.GroupService;
import SplitWisePractice2.Service.SimplifiedBalanceSheet;

import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        InMemoryRepo inMemoryRepo = new InMemoryRepo();
        BalanceSheetService balanceSheetService = new BalanceSheetService();
        ExpenseService expenseService = new ExpenseService(balanceSheetService);
        GroupService groupService = new GroupService(inMemoryRepo, expenseService, balanceSheetService);
        SimplifiedBalanceSheet simplifiedBalanceSheet = new SimplifiedBalanceSheet();

        String id = UUID.randomUUID().toString();
        Group group = groupService.createGroup(id, "Kerala Trip");

        User A = new User("id1", "A");
        User B = new User("id2", "B");
        User C = new User("id3", "C");
        User D = new User("id4", "D");

        group.addMember(A);group.addMember(B);group.addMember(C);group.addMember(D);

        groupService.addExpense(group, "Lunch Day 1", 1000, A, List.of(A,B,C), null, SplitStrategyType.EQUAL);
        groupService.addExpense(group, "Rafting", 4000, C, List.of(A,B,C,D), null, SplitStrategyType.EQUAL);

        groupService.printBalance(group);
        simplifiedBalanceSheet.simplifyBalanceSheet(group);
        System.out.println("<=====================================>");
        groupService.printBalance(group);

    }
}
