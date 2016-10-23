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
@Table(name = "CONF_FIELD")
public class ConfField implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID", nullable = false)
    private AppField appField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_FORM_ID", nullable = false)
    private IssueForm issueForm;

    @Column(name = "DISPLAY_TEXT", length = 45)
    private String displayText;

    @Column(name = "DEFAULT_VALUE", length = 45)
    private String defaultValue;

    @Column(name = "MAX_SIZE")
    private Integer maxSize;

    @Column(name = "MIN_SIZE")
    private Integer minSize;

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

    public ConfField() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public AppField getAppField() {
	return appField;
    }

    public void setAppField(AppField appField) {
	this.appField = appField;
    }

    public IssueForm getIssueForm() {
	return issueForm;
    }

    public void setIssueForm(IssueForm issueForm) {
	this.issueForm = issueForm;
    }

}
