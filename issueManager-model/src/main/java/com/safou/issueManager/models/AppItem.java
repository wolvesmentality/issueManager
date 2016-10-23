package com.safou.issueManager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APP_ITEM")
public class AppItem implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_TYPE_ID")
    private BusinessType businessType;

    @Column(name = "CODE", length = 45)
    private String code;

    @Column(name = "NAME", length = 45)
    private String name;

    @Column(name = "SHORT_NAME", length = 45)
    private String shortName;

    @Column(name = "FULL_NAME", length = 45)
    private String fullName;

    public AppItem() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public BusinessType getBusinessType() {
	return this.businessType;
    }

    public void setBusinessType(BusinessType businessType) {
	this.businessType = businessType;
    }

    public String getCode() {
	return this.code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getShortName() {
	return this.shortName;
    }

    public void setShortName(String shortName) {
	this.shortName = shortName;
    }

    public String getFullName() {
	return this.fullName;
    }

    public void setFullName(String fullName) {
	this.fullName = fullName;
    }

}
