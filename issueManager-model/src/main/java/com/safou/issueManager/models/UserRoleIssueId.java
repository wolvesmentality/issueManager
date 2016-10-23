package com.safou.issueManager.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRoleIssueId implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;

    @Column(name = "ISSUE_ID", nullable = false)
    private Long issueId;

    public UserRoleIssueId() {
    }

    public Long getUserId() {
	return this.userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public Long getRoleId() {
	return this.roleId;
    }

    public void setRoleId(Long roleId) {
	this.roleId = roleId;
    }

    public Long getIssueId() {
	return this.issueId;
    }

    public void setIssueId(Long issueId) {
	this.issueId = issueId;
    }

    public boolean equals(Object other) {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof UserRoleIssueId))
	    return false;
	UserRoleIssueId castOther = (UserRoleIssueId) other;

	return (this.getUserId() == castOther.getUserId()) && (this.getRoleId() == castOther.getRoleId())
		&& (this.getIssueId() == castOther.getIssueId());
    }

    public int hashCode() {
	int result = 17;

	result = 37 * result + this.getUserId().intValue();
	result = 37 * result + this.getRoleId().intValue();
	result = 37 * result + this.getIssueId().intValue();
	return result;
    }

}
