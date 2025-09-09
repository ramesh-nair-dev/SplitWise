package com.example.splitwise.Controller;

import com.example.splitwise.Service.DisplayTransactionService;
import com.example.splitwise.Service.SettleUpService;
import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.dtos.SettleUpRequestDTO;
import com.example.splitwise.dtos.SettleUpResponseDTO;
import com.example.splitwise.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {
    private final SettleUpService settleUpService;
    private final DisplayTransactionService displayTransactionService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService,DisplayTransactionService displayTransactionService) {
        this.settleUpService = settleUpService;
        this.displayTransactionService = displayTransactionService;
    }
    public SettleUpResponseDTO settleUp(SettleUpRequestDTO requestDTO){
        SettleUpResponseDTO responseDTO = new SettleUpResponseDTO();
        try{
            List<Transaction> transactions = settleUpService.settleUp(requestDTO.getGroupId());
            responseDTO.setTranscationList(transactions);
            responseDTO.setResponseMessage("Transaction generated Successfully !");
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setResponseMessage(e.getMessage());
        }
        // Display the transactions
        displayTransactionService.displayTransaction(responseDTO.getTranscationList());
        return responseDTO;
    }
}
