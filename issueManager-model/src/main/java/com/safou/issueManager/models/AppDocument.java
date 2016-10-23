package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "APP_DOCUMENT")
public class AppDocument implements java.io.Serializable {

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

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @Column(name = "CONTENT", nullable = false)
    private byte[] content;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED_ON", nullable = false, length = 10)
    private Date createdOn;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appDocument")
    private Set<IssueDocument> issueDocuments = new HashSet<IssueDocument>(0);

    public AppDocument() {
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

    public byte[] getContent() {
	return this.content;
    }

    public void setContent(byte[] content) {
	this.content = content;
    }

    public AppUser getCreatedBy() {
	return createdBy;
    }

    public void setCreatedBy(AppUser createdBy) {
	this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
	return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
    }

    public Set<IssueDocument> getIssueDocuments() {
	return issueDocuments;
    }

    public void setIssueDocuments(Set<IssueDocument> issueDocuments) {
	this.issueDocuments = issueDocuments;
    }

}
