package com.safou.issueManager.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE_ISSUE")
public class UserRoleIssue implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false)),
	    @AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false)),
	    @AttributeOverride(name = "issueId", column = @Column(name = "ISSUE_ID", nullable = false)) })
    private UserRoleIssueId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID", nullable = false, insertable = false, updatable = false)
    private Issue issue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
    private Role role;

    public UserRoleIssue() {
    }

    public UserRoleIssueId getId() {
	return this.id;
    }

    public void setId(UserRoleIssueId id) {
	this.id = id;
    }

    public AppUser getAppUser() {
	return this.appUser;
    }

    public void setAppUser(AppUser appUser) {
	this.appUser = appUser;
    }

    public Issue getIssue() {
	return this.issue;
    }

    public void setIssue(Issue issue) {
	this.issue = issue;
    }

    public Role getRole() {
	return this.role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

}
