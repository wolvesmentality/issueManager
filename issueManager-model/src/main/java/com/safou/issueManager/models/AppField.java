package com.safou.issueManager.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "APP_FIELD")
public class AppField implements java.io.Serializable {

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

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "APP_FIELD_TYPE_ID", nullable = false)
    private AppFieldType appFieldType;

    @Column(name = "DISPLAY_TEXT", length = 45)
    private String displayText;

    @Column(name = "DEFAULT_VALUE", length = 45)
    private String defaultValue;

    @Column(name = "MAX_SIZE")
    private Integer maxSize;

    @Column(name = "MIN_SIZE")
    private Integer minSize;

    @Column(name = "TABLE_VALUE_NAME", length = 45)
    private String tableValueName;

    @Column(name = "IS_REQUIRED")
    private Boolean isRequired;

    @Column(name = "IS_DISABLED")
    private Boolean isDisabled;

    @Column(name = "IS_HIDDEN")
    private Boolean isHidden;

    @Column(name = "IS_VALID_FOR_FORM")
    private Boolean isValidForForm;

    @Column(name = "IS_VALID_FOR_GRID")
    private Boolean isValidForGrid;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appField")
    private Set<ConfField> confFields = new HashSet<ConfField>(0);

    public AppField() {
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

    public String getName() {
	return this.name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDisplayText() {
	return this.displayText;
    }

    public void setDisplayText(String displayText) {
	this.displayText = displayText;
    }

    public String getDefaultValue() {
	return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
	this.defaultValue = defaultValue;
    }

    public Integer getMaxSize() {
	return this.maxSize;
    }

    public void setMaxSize(Integer maxSize) {
	this.maxSize = maxSize;
    }

    public Integer getMinSize() {
	return this.minSize;
    }

    public void setMinSize(Integer minSize) {
	this.minSize = minSize;
    }

    public String getTableValueName() {
	return this.tableValueName;
    }

    public void setTableValueName(String tableValueName) {
	this.tableValueName = tableValueName;
    }

    public Boolean getIsRequired() {
	return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
	this.isRequired = isRequired;
    }

    public Boolean getIsDisabled() {
	return isDisabled;
    }

    public void setIsDisabled(Boolean isDisabled) {
	this.isDisabled = isDisabled;
    }

    public Boolean getIsHidden() {
	return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
	this.isHidden = isHidden;
    }

    public Boolean getIsValidForForm() {
	return isValidForForm;
    }

    public void setIsValidForForm(Boolean isValidForForm) {
	this.isValidForForm = isValidForForm;
    }

    public Boolean getIsValidForGrid() {
	return isValidForGrid;
    }

    public void setIsValidForGrid(Boolean isValidForGrid) {
	this.isValidForGrid = isValidForGrid;
    }

    public Boolean getIsActive() {
	return isActive;
    }

    public void setIsActive(Boolean isActive) {
	this.isActive = isActive;
    }

    public AppFieldType getAppFieldType() {
	return appFieldType;
    }

    public void setAppFieldType(AppFieldType appFieldType) {
	this.appFieldType = appFieldType;
    }

    public Set<ConfField> getConfFields() {
	return confFields;
    }

    public void setConfFields(Set<ConfField> confFields) {
	this.confFields = confFields;
    }

}
