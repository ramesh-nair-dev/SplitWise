package com.example.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction extends BaseClass{
    private User userFrom;
    private User UserTo;
    private int amount;
}
