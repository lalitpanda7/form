package com.homegenius.form.dto;

import java.io.Serializable;
import java.util.List;

public class FormCreationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private List<String> mlsList;
	private List<String> formCategoryList;

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

	@Override
	public String toString() {
		return "FormCreationRequest [name=" + name + ", description=" + description + ", mlsList=" + mlsList
				+ ", formCategoryList=" + formCategoryList + "]";
	}

}
