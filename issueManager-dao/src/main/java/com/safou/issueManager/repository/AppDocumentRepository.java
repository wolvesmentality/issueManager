package com.safou.issueManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safou.issueManager.models.AppDocument;

public interface AppDocumentRepository extends JpaRepository<AppDocument, Long> {
}
