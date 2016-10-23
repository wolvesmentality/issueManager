package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.IssueDocument;

public interface IssueDocumentRepository extends JpaRepository<IssueDocument, Long> {

}
