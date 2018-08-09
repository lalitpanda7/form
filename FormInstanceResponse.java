package com.homegenius.form.dto;

import java.io.Serializable;
import java.util.Date;

import com.homegenius.form.bean.FormInstanceDetail;
import com.homegenius.form.bean.FormMetadata;

public class FormInstanceResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private String parentFormId;
	private String workflowId;
	private String transactionId;
	private String taskId;
	private Date dueDate;
	private String previewLink;
	private String fileStorageId;
	private FormMetadata formMetadata;
	private FormInstanceDetail formInstanceDetail;
	private boolean isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParentFormId() {
		return parentFormId;
	}

	public void setParentFormId(String parentFormId) {
		this.parentFormId = parentFormId;
	}

	public String getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getPreviewLink() {
		return previewLink;
	}

	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}

	public String getFileStorageId() {
		return fileStorageId;
	}

	public void setFileStorageId(String fileStorageId) {
		this.fileStorageId = fileStorageId;
	}

	public FormMetadata getFormMetadata() {
		return formMetadata;
	}

	public void setFormMetadata(FormMetadata formMetadata) {
		this.formMetadata = formMetadata;
	}

	public FormInstanceDetail getFormInstanceDetail() {
		return formInstanceDetail;
	}

	public void setFormInstanceDetail(FormInstanceDetail formInstanceDetail) {
		this.formInstanceDetail = formInstanceDetail;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "FormInstanceResponse [id=" + id + ", name=" + name + ", description=" + description + ", parentFormId="
				+ parentFormId + ", workflowId=" + workflowId + ", transactionId=" + transactionId + ", taskId="
				+ taskId + ", dueDate=" + dueDate + ", previewLink=" + previewLink + ", fileStorageId=" + fileStorageId
				+ ", formMetadata=" + formMetadata + ", formInstanceDetail=" + formInstanceDetail + ", isDeleted="
				+ isDeleted + "]";
	}

}
