package com.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Group extends BaseClass{
    private String groupName;
    @ManyToMany
    private List<User> members;
    @OneToMany
    private List<Expense> expenses;
    @ManyToOne
    private User admin;
    private UserExpenseType userExpenseType;
}

/**
 * This is the Group class which extends BaseClass.
 * 1. It represents a group in the application with fields for groupName, members, expenses, and admin.
 * 2. The class inherits common fields from BaseClass such as id, createdAt, and updatedAt.
 * 3. The groupName field is used to identify the group.
 * 4. The members field is a list of User objects representing the members of the group. so group will have list user of user in the group
 * 5. A particular group can have multiple expenses , so the we list of expenses in the group.
 * 6. Every user has one admin we are storing that for group 1 this user B is the admin of the group
 *
 * Let's define the cardinality of the Group class:
 *
 * 1. Group to User: One group can have multiple users, and a user can belong to multiple groups, so we have a many-to-many relationship.
 * 2. Group to Expense: One group can have multiple expenses, but an expense belongs to one group, so we have a one-to-many relationship.
 * 3. Group to User (admin): One group has one admin, but a user can be an admin of multiple groups, so we have a many-to-one relationship.
 *
 *
 * To cal the settle up who it will work is that we will have a list of expeneses in the group
 * - All alog will give the list of transactions that need to be done to settle up the group
 *
 * We can simple do this by having transaction enity which will have from user , to user , amount and expense ans status
 * but we don't want to create a new entity for this so will manage it expense it how
 * for example after clicking on settle up in group :
 * - We get list transactions that need to be done to settle up the like
 *  - A owes B 500
 *  - B owes C 300
 *  - C owes D 200
 *  Now if have A paid B 500 in expense entry we will add a reverse entry in expense like B owes A 500
 *  no if we agin generate again settlup we won't see A owes B 500 but we will
 */


