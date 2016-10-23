package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
