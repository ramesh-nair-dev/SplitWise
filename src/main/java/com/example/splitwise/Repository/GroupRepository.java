package com.example.splitwise.Repository;

import com.example.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group , Long> {
    Optional<Group> findByGroupName(String groupName);

}
