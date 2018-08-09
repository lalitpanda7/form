package com.homegenius.form.dto;

import java.io.Serializable;
import java.util.List;

public class FormUpdationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private List<String> mlsList;
	private List<String> formCategoryList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "FormUpdationRequest [id=" + id + ", mlsList=" + mlsList + ", formCategoryList=" + formCategoryList
				+ "]";
	}

}
