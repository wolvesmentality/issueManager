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
@Table(name = "ISSUE_TEXT")
public class IssueText implements java.io.Serializable {

    /**
     *  
     */
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "issueId", column = @Column(name = "ISSUE_ID", nullable = false)),
	    @AttributeOverride(name = "fieldId", column = @Column(name = "FIELD_ID", nullable = false)) })
    private IssueTextId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID", nullable = false, insertable = false, updatable = false)
    private AppField appField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID", nullable = false, insertable = false, updatable = false)
    private Issue issue;

    @Column(name = "value", length = 45)
    private String value;

    public IssueText() {
    }

    public IssueText(IssueTextId id, AppField appField, Issue issue) {
	this.id = id;
	this.appField = appField;
	this.issue = issue;
    }

    public IssueText(IssueTextId id, AppField appField, Issue issue, String value) {
	this.id = id;
	this.appField = appField;
	this.issue = issue;
	this.value = value;
    }

    public IssueTextId getId() {
	return this.id;
    }

    public void setId(IssueTextId id) {
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

    public String getValue() {
	return this.value;
    }

    public void setValue(String value) {
	this.value = value;
    }

}
