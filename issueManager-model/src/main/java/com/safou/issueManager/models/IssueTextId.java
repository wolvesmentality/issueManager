package com.safou.issueManager.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IssueTextId implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "ISSUE_ID", nullable = false)
    private Long issueId;

    @Column(name = "FIELD_ID", nullable = false)
    private Long fieldId;

    public IssueTextId() {
    }

    public IssueTextId(Long issueId, Long fieldId) {
	this.issueId = issueId;
	this.fieldId = fieldId;
    }

    public Long getIssueId() {
	return this.issueId;
    }

    public void setIssueId(Long issueId) {
	this.issueId = issueId;
    }

    public Long getFieldId() {
	return this.fieldId;
    }

    public void setFieldId(Long fieldId) {
	this.fieldId = fieldId;
    }

    public boolean equals(Object other) {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof IssueTextId))
	    return false;
	IssueTextId castOther = (IssueTextId) other;

	return (this.getIssueId() == castOther.getIssueId()) && (this.getFieldId() == castOther.getFieldId());
    }

    public int hashCode() {
	int result = 17;

	result = 37 * result + this.getIssueId().intValue();
	result = 37 * result + this.getFieldId().intValue();
	return result;
    }

}
