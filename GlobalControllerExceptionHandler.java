package com.homegenius.form.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homegenius.form.exception.FatalException;
import com.homegenius.form.exception.NonFatalException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
	private static final String ERRORS = "errors";

	/**
	 * Static logger for the class
	 */
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Map<String, Object> createErrorResponse(Errors errors) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String> errorResults = new HashMap<String, String>();
		for (ObjectError error : errors.getAllErrors()) {
			errorResults.put(error.getCode(), error.getDefaultMessage());
		}
		result.put(ERRORS, errorResults);
		return result;
	}

	private ErrorMessageHolder createErrorResponse(NonFatalException exception) {
		ErrorMessageHolder errorHolder = new ErrorMessageHolder();
		if (exception.getErrorCode() != null && !exception.getErrorCode().isEmpty()) {
			errorHolder.setErrorCode(exception.getErrorCode());
		}
		if (exception.getMessage() != null && !exception.getMessage().isEmpty()) {
			errorHolder.setMessage(exception.getMessage());
		}
		return errorHolder;
	}

	private ErrorMessageHolder createErrorResponse(FatalException exception) {
		ErrorMessageHolder errorHolder = new ErrorMessageHolder();
		if (exception.getMessage() != null && !exception.getMessage().isEmpty()) {
			errorHolder.setMessage("Something unexpected happened. We surely would be looking into it");
		}
		return errorHolder;
	}

	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> handleBadRequestException(BadRequestException exception) {
		Map<String, Object> result = createErrorResponse(exception.getErrors());
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NonFatalException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessageHolder> handleNonCriticalException(NonFatalException exception) {
		ErrorMessageHolder holder = createErrorResponse(exception);
		return new ResponseEntity<ErrorMessageHolder>(holder, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FatalException.class)
	@ResponseBody
	public ResponseEntity<ErrorMessageHolder> handleCriticalException(FatalException exception) {
		ErrorMessageHolder holder = createErrorResponse(exception);
		return new ResponseEntity<ErrorMessageHolder>(holder, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

class ErrorMessageHolder {
	String errorCode;
	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
