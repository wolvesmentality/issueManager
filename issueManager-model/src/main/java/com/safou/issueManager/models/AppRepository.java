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
@Table(name = "APP_REPOSITORY", catalog = "ISSUE_MANAGER")
public class AppRepository implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY")
    private AppUser createdBy;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_ON", length = 10)
    private Date createdOn;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appRepository")
    private Set<Issue> issues = new HashSet<Issue>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appRepository")
    private Set<UserRoleRepository> userRoleRepositories = new HashSet<UserRoleRepository>(0);

    public AppRepository() {
    }

    public AppRepository(String name) {
	this.name = name;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public AppUser getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
	this.createdBy = createdBy;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Date getCreatedOn() {
	return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
    }

    public Boolean getIsActive() {
	return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Set<Issue> getIssues() {
	return this.issues;
    }

    public void setIssues(Set<Issue> issues) {
	this.issues = issues;
    }

    public Set<UserRoleRepository> getUserRoleRepositories() {
	return userRoleRepositories;
    }

    public void setUserRoleRepositories(Set<UserRoleRepository> userRoleRepositories) {
	this.userRoleRepositories = userRoleRepositories;
    }

}
