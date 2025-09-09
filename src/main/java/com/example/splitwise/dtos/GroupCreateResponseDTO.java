package com.example.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupCreateResponseDTO {
    private long groupId;
    private ResponseStatus responseStatus;
    private String responseMessage;
}
