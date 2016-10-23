package com.safou.issueManager.models;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ISSUE_LINK_TYPE")
public class IssueLinkType implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false, length = 45)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "issueLinkType")
    private Set<IssueLink> issueLinks = new HashSet<IssueLink>(0);

    public IssueLinkType() {
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

    public Set<IssueLink> getIssueLinks() {
	return issueLinks;
    }

    public void setIssueLinks(Set<IssueLink> issueLinks) {
	this.issueLinks = issueLinks;
    }

}
