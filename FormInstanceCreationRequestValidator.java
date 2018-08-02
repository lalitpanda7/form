package com.homegenius.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.homegenius.form.controller.BadRequestException;
import com.homegenius.form.controller.ErrorCodes;
import com.homegenius.form.dto.FormInstanceCreationRequest;

@Component
public class FormInstanceCreationRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> classes) {
		return FormInstanceCreationRequest.class.isAssignableFrom(classes);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "parentFormId", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workflowId", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transactionId", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taskId", ErrorCodes.INVALID_INPUT.getValue());
		if (errors.hasErrors()) {
			throw new BadRequestException(errors);
		}

	}

}
