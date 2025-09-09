package com.example.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserBalance {
    private User user;
    private int amount;

}
