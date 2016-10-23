package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueText;
import com.safou.issueManager.models.IssueTextId;

public interface IssueTextRepository extends JpaRepository<IssueText, IssueTextId> {
}
