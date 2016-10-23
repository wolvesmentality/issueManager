package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ISSUE_COMMENT")
public class IssueComment implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATED_BY", nullable = false)
    private AppUser createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_ID", nullable = false)
    private Issue issue;

    @Column(name = "text", nullable = false, length = 4000)
    private String text;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_ON", nullable = false, length = 10)
    private Date createdOn;

    public IssueComment() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public AppUser getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
	this.createdBy = createdBy;
    }

    public Issue getIssue() {
	return this.issue;
    }

    public void setIssue(Issue issue) {
	this.issue = issue;
    }

    public String getText() {
	return this.text;
    }

    public void setText(String text) {
	this.text = text;
    }

    public Date getCreatedOn() {
	return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
    }

}
