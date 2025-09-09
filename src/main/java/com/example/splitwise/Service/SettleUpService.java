package com.example.splitwise.Service;

import com.example.splitwise.Repository.GroupRepository;
import com.example.splitwise.Strategy.SettleUpStrategyFactory;
import com.example.splitwise.models.Expense;
import com.example.splitwise.models.Group;
import com.example.splitwise.models.SettleUpStrategyType;
import com.example.splitwise.models.Transaction;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SettleUpService {
    private final GroupRepository groupRepository;

    public SettleUpService (GroupRepository groupRepository){
        this.groupRepository = groupRepository;
    }
    public List<Transaction> settleUp(
            long groupId
    ){

        // 1 find the group from group id
        Optional<Group> optionGroup = groupRepository.findById(groupId);
        if(optionGroup.isEmpty()){
            throw new RuntimeException("Group does not exists");
        }
        Group group = optionGroup.get();
        List<Expense> expenseList = group.getExpenses();
        List<Transaction> transactions = Objects.requireNonNull(SettleUpStrategyFactory.getSettleUpStrategy(SettleUpStrategyType.HEAP)).settleUp(expenseList);
        return transactions;
    }
}
/**
 * SettleUpService
 * ----------------
 * This service is responsible for calculating the minimal set of transactions
 * required to settle all expenses within a group. It leverages the Strategy pattern
 * to allow different settlement algorithms, providing flexibility and maintainability.
 *
 * Core Responsibilities:
 * 1. Fetch a group by its ID.
 * 2. Aggregate all expenses of the group.
 * 3. Compute settlement transactions using a selected strategy.
 * 4. Return a list of transactions required to balance debts among group members.
 *
 * Design Considerations:
 * ----------------------
 * - Strategy Pattern:
 *     - Settlement logic is decoupled using the `SettleUpStrategyFactory`.
 *     - Supports multiple strategies (e.g., HEAP-based, Greedy, etc.).
 *     - Makes the service easily extendable without modifying existing logic.
 *
 * - Null and Existence Checks:
 *     - Validates that the group exists before performing settlement.
 *     - Uses `Optional` and `Objects.requireNonNull` to avoid null pointer exceptions.
 *
 * - Transaction Representation:
 *     - Each Transaction object represents a single debt to be settled
 *       (e.g., Alice owes Bob $50).
 *     - The service does not persist these transactions; it returns them
 *       for downstream processing (UI display, notifications, or database updates).
 *
 * Method Details:
 * ----------------
 * settleUp(long groupId)
 * - Input: groupId (ID of the group to settle expenses for)
 * - Processing:
 *     1. Retrieve the Group from `GroupRepository` using the provided ID.
 *     2. Throw RuntimeException if the group does not exist.
 *     3. Extract all expenses from the group.
 *     4. Delegate settlement computation to a strategy obtained from `SettleUpStrategyFactory`.
 *        - Current default strategy: HEAP-based.
 *     5. Return the list of Transaction objects that represent the minimal set of payments required.
 *
 * - Output: List<Transaction> representing all settlement transactions.
 *
 * Example Use Case:
 * -----------------
 * Given a group with multiple shared expenses:
 *     SettleUpService.settleUp(100L);
 * Returns a list of transactions indicating who owes whom and how much to balance the group expenses.
 *
 */