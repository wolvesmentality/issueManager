package com.safou.issueManager.VOs;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class UserVO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isActive;
    private Set<RoleVO> roles = new HashSet<RoleVO>(0);

    public UserVO() {
	// TODO Auto-generated constructor stub
    }

    public UserVO(Long id, String firstName, String lastName, String email, Boolean isActive,
	    Collection<RoleVO> roleVOs) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.roles = (Set<RoleVO>) roleVOs;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public boolean isActive() {
	return isActive;
    }

    public void setActive(boolean isActive) {
	this.isActive = isActive;
    }

    public Set<RoleVO> getRoles() {
	return roles;
    }

    public void setRoles(Set<RoleVO> roles) {
	this.roles = roles;
    }

}
