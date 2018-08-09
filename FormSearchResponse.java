package com.homegenius.form.dto;

import java.io.Serializable;

public class FormSearchResponse implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String description;
	private String previewLink;
	
	
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


	public String getPreviewLink() {
		return previewLink;
	}


	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "FormResponse [id=" + id + ", name=" + name + ", description=" + description + ", previewLink="
				+ previewLink + "]";
	}
}
