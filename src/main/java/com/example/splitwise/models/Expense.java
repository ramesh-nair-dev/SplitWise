package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseClass{
    @ManyToOne
    private User user;
    private String description;
    private int amount;
    @ManyToOne
    private Group group;
    @OneToMany
    private List<UserExpense> userExpenseList;
    private ExpenseType expenseType;

}

/**
 * This is the Expense class which extends BaseClass.
 * 1. It represents an expense in the application with fields for name, description, amount, and group.
 * 2. The class inherits common fields from BaseClass such as id, createdAt, and updatedAt.
 * 3. The name field is used to identify the expense.
 * 4. The description field provides additional details about the expense.
 * 5. The amount field represents the monetary value of the expense.
 * 6. The group field is a reference to the Group object to which this expense belongs, allowing for association with a specific group of users.
 *
 * Now : We have expense group name goa trip in that we will one expense
 *       - name : dinner
 *       - description : dinner at goa
 *       - amount : 2000
 *       - group : goa trip
 *       so what A and B did they payment both of them paid 1000 each
 *       A was supposed to pay 500 and B was supposed to pay 500
 *       C was supposed to pay 500 but paid 0 and D was supposed to pay 500 but paid 0
 *
 *       Now did we obeserve for one expense we have different expense involved like
 *       To store that we will nee a seperate class userExpense which will expense , userExpense type enum of paid , or need to pay like
 *
 * Let's define the cardinality of the Expense class:
 *
 * 1. Expense to Group: One expense entry can belone to one group, but a group can have multiple expenses we have have many to one relationship
 * 2. Expense to UserExpense: One expense can have multiple user expenses associated with it, like expense hany three paid_for user expense and 3 paid_for user expense so o expense can have multiple user expense
 *                            but on user expense can belong to one expense so we have one to many relationship
 * 3. Expense to User: One expense is created by one user, but a user can create multiple expenses so we have many to one relationship
 */
