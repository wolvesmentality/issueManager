package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueLink;

public interface IssueLinkRepository extends JpaRepository<IssueLink, Long> {
}
