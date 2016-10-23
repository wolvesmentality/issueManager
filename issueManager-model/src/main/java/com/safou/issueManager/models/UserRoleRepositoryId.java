package com.safou.issueManager.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRoleRepositoryId implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "REPOSITRORY_ID", nullable = false)
    private Long repositroryId;

    @Column(name = "ROLE_ID", nullable = false)
    private Long roleId;

    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    public UserRoleRepositoryId() {
    }

    public Long getRepositroryId() {
	return this.repositroryId;
    }

    public void setRepositroryId(Long repositroryId) {
	this.repositroryId = repositroryId;
    }

    public Long getRoleId() {
	return this.roleId;
    }

    public void setRoleId(Long roleId) {
	this.roleId = roleId;
    }

    public Long getUserId() {
	return this.userId;
    }

    public void setUserId(Long userId) {
	this.userId = userId;
    }

    public boolean equals(Object other) {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof UserRoleRepositoryId))
	    return false;
	UserRoleRepositoryId castOther = (UserRoleRepositoryId) other;

	return (this.getRepositroryId() == castOther.getRepositroryId()) && (this.getRoleId() == castOther.getRoleId())
		&& (this.getUserId() == castOther.getUserId());
    }

    public int hashCode() {
	int result = 17;

	result = 37 * result + this.getRepositroryId().intValue();
	result = 37 * result + this.getRoleId().intValue();
	result = 37 * result + this.getUserId().intValue();
	return result;
    }

}
