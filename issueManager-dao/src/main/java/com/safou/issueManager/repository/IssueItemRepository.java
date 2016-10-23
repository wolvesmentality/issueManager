package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueItem;

public interface IssueItemRepository extends JpaRepository<IssueItem, Long> {
}
