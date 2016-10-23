package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppFieldType;

public interface AppFieldTypeRepository extends JpaRepository<AppFieldType, Long> {
}
