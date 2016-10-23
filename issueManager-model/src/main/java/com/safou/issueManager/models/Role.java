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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements java.io.Serializable {

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

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRoleRepository> userRoleRepositories = new HashSet<UserRoleRepository>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<UserRoleIssue> userRoleIssues = new HashSet<UserRoleIssue>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ROLE_PRIVILEGE", joinColumns = {
	    @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
		    @JoinColumn(name = "PRIVILEGE_ID", nullable = false, updatable = false) })
    private Set<Privilege> privileges = new HashSet<Privilege>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_ROLE", joinColumns = {
	    @JoinColumn(name = "ROLE_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
		    @JoinColumn(name = "USER_ID", nullable = false, updatable = false) })
    private Set<AppUser> users = new HashSet<AppUser>(0);

    public Role() {
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

    public Boolean getIsActive() {
	return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public Set<UserRoleRepository> getUserRoleRepositories() {
	return this.userRoleRepositories;
    }

    public void setUserRoleRepositories(Set<UserRoleRepository> userRoleRepositories) {
	this.userRoleRepositories = userRoleRepositories;
    }

    public Set<UserRoleIssue> getUserRoleIssues() {
	return this.userRoleIssues;
    }

    public void setUserRoleIssues(Set<UserRoleIssue> userRoleIssues) {
	this.userRoleIssues = userRoleIssues;
    }

    public Set<Privilege> getPrivileges() {
	return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
	this.privileges = privileges;
    }

    public Set<AppUser> getUsers() {
	return users;
    }

    public void setUsers(Set<AppUser> users) {
	this.users = users;
    }

}
