package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE_DOCUMENT")
public class IssueDocument implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_ID", nullable = false)
    private AppDocument appDocument;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID", nullable = false)
    private Issue issue;

    public IssueDocument() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public AppDocument getAppDocument() {
	return this.appDocument;
    }

    public void setAppDocument(AppDocument appDocument) {
	this.appDocument = appDocument;
    }

    public Issue getIssue() {
	return this.issue;
    }

    public void setIssue(Issue issue) {
	this.issue = issue;
    }

}
