package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppUserCredential;

public interface AppUserCredentialRepository extends JpaRepository<AppUserCredential, Long> {
}
