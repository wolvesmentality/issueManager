package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.UserRoleRepository;
import com.safou.issueManager.models.UserRoleRepositoryId;

public interface UserRoleRepoRepository extends JpaRepository<UserRoleRepository, UserRoleRepositoryId> {
}
