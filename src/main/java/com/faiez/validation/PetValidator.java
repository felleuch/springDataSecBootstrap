package com.faiez.validation;

import com.faiez.model.Pet;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by faiez.elleuch on 19/02/14.
 */

@Component
public class PetValidator implements Validator {
	@Override
	public boolean supports(Class<?> aClass) {
		return Pet.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

	}
}
