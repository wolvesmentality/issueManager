package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ISSUE")
public class Issue implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPOSITORY_ID", nullable = false)
    private AppRepository appRepository;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", nullable = false)
    private AppUser createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_FORM_ID", nullable = false)
    private IssueForm issueForm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_TYPE_ID", nullable = false)
    private IssueType issueType;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_ON", nullable = false, length = 10)
    private Date createdOn;

    @Temporal(TemporalType.DATE)
    @Column(name = "DELETED_ON", length = 10)
    private Date deletedOn;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private Set<IssueItem> issueItems = new HashSet<IssueItem>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private Set<IssueText> issueTexts = new HashSet<IssueText>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private Set<IssueNumeric> issueNumerics = new HashSet<IssueNumeric>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private Set<IssueDocument> issueDocuments = new HashSet<IssueDocument>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
    private Set<IssueLink> childIssueLinks = new HashSet<IssueLink>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "child")
    private Set<IssueLink> parentIssueLinks = new HashSet<IssueLink>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private Set<IssueComment> issueComments = new HashSet<IssueComment>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issue")
    private Set<UserRoleIssue> userRoleIssues = new HashSet<UserRoleIssue>(0);

    public Issue() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public AppRepository getAppRepository() {
	return this.appRepository;
    }

    public void setAppRepository(AppRepository appRepository) {
	this.appRepository = appRepository;
    }

    public IssueForm getIssueForm() {
	return this.issueForm;
    }

    public void setIssueForm(IssueForm issueForm) {
	this.issueForm = issueForm;
    }

    public IssueType getIssueType() {
	return this.issueType;
    }

    public void setIssueType(IssueType issueType) {
	this.issueType = issueType;
    }

    public Date getCreatedOn() {
	return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
    }

    public Date getDeletedOn() {
	return this.deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
	this.deletedOn = deletedOn;
    }

    public Boolean getIsActive() {
	return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public AppUser getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
	this.createdBy = createdBy;
    }

    public Set<IssueItem> getIssueItems() {
	return issueItems;
    }

    public void setIssueItems(Set<IssueItem> issueItems) {
	this.issueItems = issueItems;
    }

    public Set<IssueText> getIssueTexts() {
	return issueTexts;
    }

    public void setIssueTexts(Set<IssueText> issueTexts) {
	this.issueTexts = issueTexts;
    }

    public Set<IssueNumeric> getIssueNumerics() {
	return issueNumerics;
    }

    public void setIssueNumerics(Set<IssueNumeric> issueNumerics) {
	this.issueNumerics = issueNumerics;
    }

    public Set<IssueDocument> getIssueDocuments() {
	return issueDocuments;
    }

    public void setIssueDocuments(Set<IssueDocument> issueDocuments) {
	this.issueDocuments = issueDocuments;
    }

    public Set<IssueLink> getChildIssueLinks() {
	return childIssueLinks;
    }

    public void setChildIssueLinks(Set<IssueLink> childIssueLinks) {
	this.childIssueLinks = childIssueLinks;
    }

    public Set<IssueLink> getParentIssueLinks() {
	return parentIssueLinks;
    }

    public void setParentIssueLinks(Set<IssueLink> parentIssueLinks) {
	this.parentIssueLinks = parentIssueLinks;
    }

    public Set<IssueComment> getIssueComments() {
	return issueComments;
    }

    public void setIssueComments(Set<IssueComment> issueComments) {
	this.issueComments = issueComments;
    }

    public Set<UserRoleIssue> getUserRoleIssues() {
	return userRoleIssues;
    }

    public void setUserRoleIssues(Set<UserRoleIssue> userRoleIssues) {
	this.userRoleIssues = userRoleIssues;
    }

}
