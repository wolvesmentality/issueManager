package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppRepository;

public interface AppRepositoryRepository extends JpaRepository<AppRepository, Long> {
}
