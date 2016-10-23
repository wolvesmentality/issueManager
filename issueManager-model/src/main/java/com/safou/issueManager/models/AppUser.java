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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER")
public class AppUser implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "FIRST_NAME", length = 45)
    private String firstName;

    @Column(name = "LAST_NAME", length = 45)
    private String lastName;

    @Column(name = "EMAIL", length = 45)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREDENTIAL_ID", nullable = false)
    private AppUserCredential appUserCredential;

    @Column(name = "IS_ACTIVE", nullable = false)
    private boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<AppRepository> createdRepositories = new HashSet<AppRepository>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<Issue> createdIssues = new HashSet<Issue>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<AppDocument> createdDocuments = new HashSet<AppDocument>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "createdBy")
    private Set<IssueComment> issueComments = new HashSet<IssueComment>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private Set<UserRoleRepository> userRoleRepositories = new HashSet<UserRoleRepository>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE", joinColumns = {
	    @JoinColumn(name = "USER_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
		    @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) })
    private Set<Role> roles = new HashSet<Role>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private Set<UserRoleIssue> userRoleIssues = new HashSet<UserRoleIssue>(0);

    public AppUser() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getFirstName() {
	return this.firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return this.lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public AppUserCredential getAppUserCredential() {
	return appUserCredential;
    }

    public void setAppUserCredential(AppUserCredential appUserCredential) {
	this.appUserCredential = appUserCredential;
    }

    public boolean isIsActive() {
	return this.isActive;
    }

    public void setIsActive(boolean isActive) {
	this.isActive = isActive;
    }

    public boolean isActive() {
	return isActive;
    }

    public void setActive(boolean isActive) {
	this.isActive = isActive;
    }

    public Set<AppRepository> getCreatedRepositories() {
	return createdRepositories;
    }

    public void setCreatedRepositories(Set<AppRepository> createdRepositories) {
	this.createdRepositories = createdRepositories;
    }

    public Set<Issue> getCreatedIssues() {
	return createdIssues;
    }

    public void setCreatedIssues(Set<Issue> createdIssues) {
	this.createdIssues = createdIssues;
    }

    public Set<AppDocument> getCreatedDocuments() {
	return createdDocuments;
    }

    public void setCreatedDocuments(Set<AppDocument> createdDocuments) {
	this.createdDocuments = createdDocuments;
    }

    public Set<IssueComment> getIssueComments() {
	return issueComments;
    }

    public void setIssueComments(Set<IssueComment> issueComments) {
	this.issueComments = issueComments;
    }

    public Set<UserRoleRepository> getUserRoleRepositories() {
	return userRoleRepositories;
    }

    public void setUserRoleRepositories(Set<UserRoleRepository> userRoleRepositories) {
	this.userRoleRepositories = userRoleRepositories;
    }

    public Set<Role> getRoles() {
	return roles;
    }

    public void setRoles(Set<Role> roles) {
	this.roles = roles;
    }

    public Set<UserRoleIssue> getUserRoleIssues() {
	return userRoleIssues;
    }

    public void setUserRoleIssues(Set<UserRoleIssue> userRoleIssues) {
	this.userRoleIssues = userRoleIssues;
    }

}
