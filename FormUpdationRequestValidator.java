package com.homegenius.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.homegenius.form.controller.BadRequestException;
import com.homegenius.form.controller.ErrorCodes;
import com.homegenius.form.dto.FormUpdationRequest;

@Component
public class FormUpdationRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> classes) {
		return FormUpdationRequest.class.isAssignableFrom(classes);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmpty(errors, "mlsList", ErrorCodes.INVALID_INPUT.getValue());
		ValidationUtils.rejectIfEmpty(errors, "formCategoryList", ErrorCodes.INVALID_INPUT.getValue());
		if (errors.hasErrors()) {
			throw new BadRequestException(errors);
		}
	}

}
