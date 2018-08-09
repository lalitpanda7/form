package com.homegenius.form.dto;

import java.io.Serializable;

public class FormInstanceCreationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String parentFormId;
	private String workflowId;
	private String transactionId;
	private String taskId;

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

	@Override
	public String toString() {
		return "FormInstanceCreationRequest [parentFormId=" + parentFormId + ", workflowId=" + workflowId
				+ ", transactionId=" + transactionId + ", taskId=" + taskId + "]";
	}

}
