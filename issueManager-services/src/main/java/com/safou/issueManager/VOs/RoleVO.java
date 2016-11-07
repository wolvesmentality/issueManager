package com.safou.issueManager.VOs;

import org.springframework.security.core.GrantedAuthority;

public class RoleVO implements GrantedAuthority {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Boolean isActive;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    @Override
    public String getAuthority() {
	return name;
    }

}
