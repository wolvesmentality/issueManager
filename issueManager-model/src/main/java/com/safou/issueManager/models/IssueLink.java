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
@Table(name = "ISSUE_LINK")
public class IssueLink implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CHILD_ISSUE_ID", nullable = false)
    private Issue child;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ISSUE_ID", nullable = false)
    private Issue parent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ISSUE_LINK_TYPE_ID", nullable = false)
    private IssueLinkType issueLinkType;

    public IssueLink() {
    }

    public Long getId() {
	return this.id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Issue getChild() {
	return child;
    }

    public void setChild(Issue child) {
	this.child = child;
    }

    public Issue getParent() {
	return parent;
    }

    public void setParent(Issue parent) {
	this.parent = parent;
    }

    public IssueLinkType getIssueLinkType() {
	return this.issueLinkType;
    }

    public void setIssueLinkType(IssueLinkType issueLinkType) {
	this.issueLinkType = issueLinkType;
    }

}
