package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE_ITEM")
public class IssueItem implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID", nullable = false)
    private AppField appField;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    private AppItem appItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID", nullable = false)
    private Issue issue;

    @Column(name = "VALUE", length = 45)
    private String value;

    public IssueItem() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public AppField getAppField() {
	return this.appField;
    }

    public void setAppField(AppField appField) {
	this.appField = appField;
    }

    public AppItem getAppItem() {
	return this.appItem;
    }

    public void setAppItem(AppItem appItem) {
	this.appItem = appItem;
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
