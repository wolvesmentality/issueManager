package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
