package com.faiez.validation;

import com.faiez.model.Owner;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by faiez.elleuch on 24/02/14.
 */
@Component
public class OwnerValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Owner.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

	}

}
