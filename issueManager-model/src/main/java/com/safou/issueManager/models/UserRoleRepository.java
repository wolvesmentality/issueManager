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
@Table(name = "USER_ROLE_REPOSITORY")
public class UserRoleRepository implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({
	    @AttributeOverride(name = "repositroryId", column = @Column(name = "REPOSITRORY_ID", nullable = false)),
	    @AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false)),
	    @AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false)) })
    private UserRoleRepositoryId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPOSITRORY_ID", nullable = false, insertable = false, updatable = false)
    private AppRepository appRepository;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
    private AppUser appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
    private Role role;

    public UserRoleRepository() {
    }

    public UserRoleRepositoryId getId() {
	return this.id;
    }

    public void setId(UserRoleRepositoryId id) {
	this.id = id;
    }

    public AppRepository getAppRepository() {
	return this.appRepository;
    }

    public void setAppRepository(AppRepository appRepository) {
	this.appRepository = appRepository;
    }

    public AppUser getAppUser() {
	return this.appUser;
    }

    public void setAppUser(AppUser appUser) {
	this.appUser = appUser;
    }

    public Role getRole() {
	return this.role;
    }

    public void setRole(Role role) {
	this.role = role;
    }

}
