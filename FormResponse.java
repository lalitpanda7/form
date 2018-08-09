package com.homegenius.form.dto;

import java.io.Serializable;
import java.util.List;

import com.homegenius.form.bean.FormMetadata;

public class FormResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String description;
	private List<String> mlsList;
	private List<String> formCategoryList;
	private FormMetadata formMetadata;
	private String previewLink;
	private String fileStorageId;
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

	public FormMetadata getFormMetadata() {
		return formMetadata;
	}

	public void setFormMetadata(FormMetadata formMetadata) {
		this.formMetadata = formMetadata;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "FormResponse [id=" + id + ", name=" + name + ", description=" + description + ", mlsList=" + mlsList
				+ ", formCategoryList=" + formCategoryList + ", formMetadata=" + formMetadata + ", previewLink="
				+ previewLink + ", fileStorageId=" + fileStorageId + ", isDeleted=" + isDeleted + "]";
	}

}
