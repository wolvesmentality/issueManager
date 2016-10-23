package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE_FORM")
public class IssueForm implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_TYPE_ID", nullable = false)
    private IssueType issueType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueForm")
    private Set<ConfField> confFields = new HashSet<ConfField>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueForm")
    private Set<Issue> issues = new HashSet<Issue>(0);

    public IssueForm() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public IssueType getIssueType() {
	return issueType;
    }

    public void setIssueType(IssueType issueType) {
	this.issueType = issueType;
    }

    public Set<ConfField> getConfFields() {
	return this.confFields;
    }

    public void setConfFields(Set<ConfField> confFields) {
	this.confFields = confFields;
    }

    public Set<Issue> getIssues() {
	return issues;
    }

    public void setIssues(Set<Issue> issues) {
	this.issues = issues;
    }

}
