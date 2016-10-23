package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.UserRoleIssue;
import com.safou.issueManager.models.UserRoleIssueId;

public interface UserRoleIssueRepository extends JpaRepository<UserRoleIssue, UserRoleIssueId> {
}
