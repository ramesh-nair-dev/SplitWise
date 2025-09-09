package com.example.splitwise.Strategy;

import com.example.splitwise.models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HeapStrategy implements SettleUpStrategy{
    @Override
    public List<Transaction> settleUp(List<Expense> expenseList) {
        Map<User, Integer> userBalances = new HashMap<>();
        for(Expense expense : expenseList){
            for(UserExpense userExpense : expense.getUserExpenseList()){
                User user = userExpense.getName();
                int amount = userExpense.getAmount();

                if(userExpense.getUserExpenseType().equals(UserExpenseType.PAID_BY)){
                    userBalances.put(user,userBalances.getOrDefault(user,0)+ amount);
                } else if (userExpense.getUserExpenseType().equals(UserExpenseType.PAID_FOR)){
                    userBalances.put(user,userBalances.getOrDefault(user,0)- amount);
                }
            }
        }

        PriorityQueue<UserBalance> maxReceiverHeap = new PriorityQueue<>((a, b) -> b.getAmount() - a.getAmount()); // Max amount to receive
        PriorityQueue<UserBalance> maxPayerHeap = new PriorityQueue<>((a,b)-> b.getAmount() - a.getAmount()); // Min amount to pay

        for(User user : userBalances.keySet()){
            int balance = userBalances.get(user);
            if(balance > 0){
                maxReceiverHeap.add(new UserBalance(user, balance));
            } else if (balance < 0) {
                maxPayerHeap.add(new UserBalance(user, -balance)); // Store as positive for min heap
            }
        }

        List<Transaction> transactions = new java.util.ArrayList<>();

        while(!maxReceiverHeap.isEmpty() && !maxPayerHeap.isEmpty()){
            UserBalance receiver = maxReceiverHeap.poll();
            UserBalance payer = maxPayerHeap.poll();

            int transferAmount = Math.min(receiver.getAmount(), payer.getAmount());
            transactions.add(new Transaction(payer.getUser(), receiver.getUser(), transferAmount));

            // Update the balances
            if(receiver.getAmount() > transferAmount){
                maxReceiverHeap.add(new UserBalance(receiver.getUser(), receiver.getAmount()-transferAmount));
            }

            if(payer.getAmount()> transferAmount){
                maxPayerHeap.add(new UserBalance(payer.getUser(), payer.getAmount()-transferAmount));
            }

        }
        return transactions;

    }
}

/**
 * This is the HeapStrategy class which implements SettleUpStrategy.
 * 1. It provides a strategy for settling up expenses using a heap-based approach.
 * 2. The class overrides the settleUp method to calculate transactions based on user balances.
 * 3. It uses two priority queues: one for users who need to receive money (max heap) and one for users who need to pay money (min heap).
 * 4. The method iterates through the expenses, calculates user balances, and generates transactions to settle up the debts.
 * 5. The transactions are returned as a list of Transaction objects, representing the amounts owed between users.
 */
