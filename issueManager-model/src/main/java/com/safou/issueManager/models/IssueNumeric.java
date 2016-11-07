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
@Table(name = "ISSUE_NUMERIC")
public class IssueNumeric implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "issueId", column = @Column(name = "ISSUE_ID", nullable = false)),
	    @AttributeOverride(name = "fieldId", column = @Column(name = "FIELD_ID", nullable = false)) })
    private IssueNumericId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID", nullable = false, insertable = false, updatable = false)
    private AppField appField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID", nullable = false, insertable = false, updatable = false)
    private Issue issue;

    @Column(name = "VALUE", nullable = false, precision = 12, scale = 0)
    private Float value;

    public IssueNumeric() {
    }

    public IssueNumericId getId() {
	return this.id;
    }

    public void setId(IssueNumericId id) {
	this.id = id;
    }

    public AppField getAppField() {
	return this.appField;
    }

    public void setAppField(AppField appField) {
	this.appField = appField;
    }

    public Issue getIssue() {
	return this.issue;
    }

    public void setIssue(Issue issue) {
	this.issue = issue;
    }

    public float getValue() {
	return this.value;
    }

    public void setValue(float value) {
	this.value = value;
    }

}
