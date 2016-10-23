package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueNumeric;
import com.safou.issueManager.models.IssueNumericId;

public interface IssueNumericRepository extends JpaRepository<IssueNumeric, IssueNumericId> {
}
