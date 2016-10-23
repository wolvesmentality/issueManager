package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
