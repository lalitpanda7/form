package com.homegenius.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.homegenius.form.controller.BadRequestException;
import com.homegenius.form.controller.ErrorCodes;
import com.homegenius.form.dto.FormCreationRequest;

@Component
public class FormCreationRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> classes) {
		return FormCreationRequest.class.isAssignableFrom(classes);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmpty(errors, "mlsList", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmpty(errors, "formCategoryList", ErrorCodes.INVALID_INPUT.getValue());
		if (errors.hasErrors()) {
			throw new BadRequestException(errors);
		}
	}

}
