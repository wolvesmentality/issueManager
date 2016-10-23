package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueForm;

public interface IssueFormRepository extends JpaRepository<IssueForm, Long> {
}
