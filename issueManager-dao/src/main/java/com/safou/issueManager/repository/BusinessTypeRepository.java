package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppField;

public interface BusinessTypeRepository extends JpaRepository<AppField, Long> {
}
