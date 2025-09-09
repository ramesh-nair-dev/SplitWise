package com.example.splitwise.dtos;

import com.example.splitwise.models.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SettleUpResponseDTO {
    private List<Transaction> transcationList;
    private ResponseStatus responseStatus;
    private String responseMessage;
}
