package com.example.splitwise.dtos;

import com.example.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupCreateRequestDTO {
    private long userId;
    private String groupName;
    private List<User> members;
    private long groupId;
}

