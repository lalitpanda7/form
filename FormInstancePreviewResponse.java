package com.homegenius.form.dto;

import java.io.Serializable;

public class FormInstancePreviewResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String previewLink;


	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPreviewLink() {
		return previewLink;
	}


	public void setPreviewLink(String previewLink) {
		this.previewLink = previewLink;
	}
	@Override
	public String toString() {
		return "FormInstancePreview [id=" + id + ", previewLink" + previewLink + "]";
	}

}
