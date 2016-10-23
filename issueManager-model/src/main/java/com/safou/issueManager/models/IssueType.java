package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE_TYPE")
public class IssueType implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueType")
    private Set<IssueForm> issueForms = new HashSet<IssueForm>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueType")
    private Set<Issue> issues = new HashSet<Issue>(0);

    public IssueType() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Set<IssueForm> getIssueForms() {
	return this.issueForms;
    }

    public void setIssueForms(Set<IssueForm> issueForms) {
	this.issueForms = issueForms;
    }

    public Set<Issue> getIssues() {
	return issues;
    }

    public void setIssues(Set<Issue> issues) {
	this.issues = issues;
    }

}
