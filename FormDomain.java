package com.homegenius.form.dto;

import java.io.Serializable;
import java.util.List;

import com.homegenius.form.bean.FileStorage;
import com.homegenius.form.bean.FormMetadata;
import com.homegenius.form.enums.FormStatus;

public class FormDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private boolean isReadOnly;
	private boolean isDeleted;
	private FormStatus formStatus;
	private List<String> mlsList;
	private List<String> formCategoryList;
	private FileStorage fileStorage;
	private FormMetadata formMetadata;
	private String createdBy;
	private String updatedBy;

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

	public boolean isReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public FormStatus getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(FormStatus formStatus) {
		this.formStatus = formStatus;
	}

	public List<String> getMlsList() {
		return mlsList;
	}

	public void setMlsList(List<String> mlsList) {
		this.mlsList = mlsList;
	}

	public List<String> getFormCategoryList() {
		return formCategoryList;
	}

	public void setFormCategoryList(List<String> formCategoryList) {
		this.formCategoryList = formCategoryList;
	}

	public FileStorage getFileStorage() {
		return fileStorage;
	}

	public void setFileStorage(FileStorage fileStorage) {
		this.fileStorage = fileStorage;
	}

	public FormMetadata getFormMetadata() {
		return formMetadata;
	}

	public void setFormMetadata(FormMetadata formMetadata) {
		this.formMetadata = formMetadata;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "FormDomain [name=" + name + ", description=" + description + ", isReadOnly=" + isReadOnly
				+ ", isDeleted=" + isDeleted + ", formStatus=" + formStatus + ", mlsList=" + mlsList
				+ ", formCategoryList=" + formCategoryList + ", fileStorage=" + fileStorage + ", formMetadata="
				+ formMetadata + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

}
