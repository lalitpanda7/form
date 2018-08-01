package com.homegenius.form.controller;

import org.springframework.validation.Errors;

import com.homegenius.form.exception.FatalException;

public class BadRequestException extends FatalException {

	private static final long serialVersionUID = 1L;
	private Errors errors;

	public BadRequestException(Errors errors) {
		this.errors = errors;
	}

	public Errors getErrors() {
		return errors;
	}

}
