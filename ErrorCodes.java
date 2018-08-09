package com.homegenius.form.controller;

public enum ErrorCodes {

	// FormsManagement API error codes
	INVALID_INPUT("invalid search parameters"), RECORD_NOT_FOUND("record not found"), RECORD_ALREADY_EXISTS(
			"record already exists");

	private String value;

	private ErrorCodes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
