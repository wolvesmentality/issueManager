package com.safou.issueManager.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESS_TYPE")
public class BusinessType implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessType")
    private Set<AppField> appFields = new HashSet<AppField>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "businessType")
    private Set<AppItem> appItems = new HashSet<AppItem>(0);

    public BusinessType() {
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

    public Set<AppField> getAppFields() {
	return this.appFields;
    }

    public void setAppFields(Set<AppField> appFields) {
	this.appFields = appFields;
    }

    public Set<AppItem> getAppItems() {
	return this.appItems;
    }

    public void setAppItems(Set<AppItem> appItems) {
	this.appItems = appItems;
    }

}
