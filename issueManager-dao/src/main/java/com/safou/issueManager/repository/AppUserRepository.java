package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
