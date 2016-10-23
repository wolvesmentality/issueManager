package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueType;

public interface IssueTypeRepository extends JpaRepository<IssueType, Long> {
}
