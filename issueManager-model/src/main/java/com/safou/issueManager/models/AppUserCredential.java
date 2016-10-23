package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USER_CREDENTIAL")
public class AppUserCredential implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "LOGIN", nullable = false, length = 45)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 45)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUserCredential")
    private Set<AppUser> appUsers = new HashSet<AppUser>(0);

    public AppUserCredential() {
    }

    public AppUserCredential(String login, String password) {
	this.login = login;
	this.password = password;
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getLogin() {
	return this.login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Set<AppUser> getAppUsers() {
	return appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
	this.appUsers = appUsers;
    }

}
