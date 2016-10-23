package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppItem;

public interface AppItemRepository extends JpaRepository<AppItem, Long> {
}
