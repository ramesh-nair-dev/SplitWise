package com.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserExpense extends BaseClass{
    @ManyToOne
    private User name;
    @ManyToOne
    private Expense expense;
    @Enumerated(EnumType.STRING)
    private UserExpenseType userExpenseType;
    private int amount;
}

/**
 * This is a user expense class
 * - As we discussed that one expense can have multiple user expense for dinner
 *   - A for expense dinner user expense type was paid and amount 1000 --> this one particular userexpense object like this on expense entry can have multiple userexpense entry
 *   - B for expense dinner user expense type was paid and amount 1000
 *   - C for expense dinner user expense type was needTo pay amount 500
 *
 * Let's define the cardinality of the UserExpense class:
 * 1. UserExpense to User: One user can have multiple user expenses, but a user expense belongs to one user, so we have a many-to-one relationship.
 * 2. UserExpense to Expense: One expense can have multiple user expenses, but a user expense belongs to one expense, so we have a many-to-one relationship.
 */
