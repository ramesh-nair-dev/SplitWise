package com.example.splitwise.Controller;

import com.example.splitwise.Service.GroupService;
import com.example.splitwise.dtos.GroupCreateRequestDTO;
import com.example.splitwise.dtos.GroupCreateResponseDTO;
import com.example.splitwise.dtos.ResponseStatus;
import com.example.splitwise.models.Group;

public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService createGroupService) {
        this.groupService = createGroupService;
    }

    public GroupCreateResponseDTO createGroup(
            GroupCreateRequestDTO requestDTO
    ){
        GroupCreateResponseDTO responseDTO = new GroupCreateResponseDTO();
        try{
            Group group = groupService.creatGroup(requestDTO.getUserId(),requestDTO.getGroupName(),requestDTO.getMembers());
            responseDTO.setGroupId(group.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setResponseMessage(group.getGroupName()+" group created successfully!");

        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setResponseMessage(e.getMessage());
        }
        return responseDTO;
    }

    public GroupCreateResponseDTO addMemberToGroup(
            GroupCreateRequestDTO requestDTO
    ){
        GroupCreateResponseDTO responseDTO = new GroupCreateResponseDTO();
        try{
            Group group = groupService.addMemberToGroup(requestDTO.getUserId(),requestDTO.getMembers(),requestDTO.getGroupId());
            responseDTO.setGroupId(group.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setResponseMessage("Member added successfully to group: " + group.getGroupName());
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setResponseMessage("Failed to add member to group: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return responseDTO;
    }

    public GroupCreateResponseDTO deleteMemberFromGroup(
            GroupCreateRequestDTO requestDTO
    ){
        GroupCreateResponseDTO responseDTO = new GroupCreateResponseDTO();
        try{
            Group group = groupService.removeMemberFromGroup(requestDTO.getUserId(),requestDTO.getMembers(),requestDTO.getGroupId());
            responseDTO.setGroupId(group.getId());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setResponseMessage("Member deleted successfully from group: " + group.getGroupName());
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setResponseMessage("Failed to delete member from group: " + e.getMessage());
        }
        return responseDTO;
    }
}

