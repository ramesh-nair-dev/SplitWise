package com.example.splitwise.Service;

import com.example.splitwise.models.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayTransactionService {
    public void  displayTransaction(List<Transaction> transactionList){
        for(Transaction transaction : transactionList){
            System.out.println(transaction.getUserFrom().getName() + "owes " + transaction.getAmount() + " money to " + transaction.getUserTo());
        }

    }
}
/**
 * DisplayTransactionService
 * -------------------------
 * This service is responsible for displaying financial transactions
 * between users in the system. It is a simple, read-only service primarily
 * intended for console-based or logging output.
 *
 * Key Responsibilities:
 * 1. Display transactions in a human-readable format.
 * 2. Iterate over a list of Transaction objects and print details of
 *    who owes whom and how much.
 *
 * Method Explanation:
 * ------------------
 * displayTransaction(List<Transaction> transactionList)
 * - Input: A List of Transaction objects representing transactions to display.
 * - Processing:
 *      - Iterates through each Transaction in the list.
 *      - Retrieves the debtor (userFrom), creditor (userTo), and the amount.
 *      - Constructs a user-friendly string in the format:
 *            "<UserFrom> owes <Amount> money to <UserTo>"
 *      - Prints the transaction details to the console using System.out.println.
 * - Output: Console/log output only. No changes are made to data or database.
 *
 * Design Considerations:
 * ----------------------
 * 1. Separation of Concerns:
 *      - This service focuses purely on display logic.
 *      - It does not handle transaction creation, modification, or persistence,
 *        which is delegated to other services/repositories.
 *
 * 2. Scalability & Maintainability:
 *      - Currently outputs to console, which is suitable for debugging or
 *        CLI-based applications.
 *      - For production-grade applications, consider replacing System.out.println
 *        with a logger or returning formatted strings for UI consumption.
 *
 * 3. Readability:
 *      - Constructs the message dynamically using Transaction object getters
 *        to ensure correct user names and amounts are displayed.
 *
 * 4. Potential Enhancements:
 *      - Add sorting (e.g., by amount or by user) before display for better readability.
 *      - Support formatted output (currency symbols, alignment) for cleaner presentation.
 *      - Integrate with frontend or REST API responses instead of direct console output.
 *
 * Example:
 * ----------
 * Given a transaction where Alice owes Bob $50:
 *     Alice owes 50.0 money to Bob
 *
 * This design demonstrates clear separation of responsibilities, concise
 * iteration over domain objects, and easy adaptability for future enhancements.
 */