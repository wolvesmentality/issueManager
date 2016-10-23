package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueComment;

public interface IssueCommentRepository extends JpaRepository<IssueComment, Long> {
}
