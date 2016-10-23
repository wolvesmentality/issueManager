package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppField;

public interface AppFieldRepository extends JpaRepository<AppField, Long> {
}
