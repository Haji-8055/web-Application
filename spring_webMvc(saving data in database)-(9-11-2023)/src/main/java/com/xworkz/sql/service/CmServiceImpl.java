package com.xworkz.sql.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Service;

import com.xworkz.sql.dto.CMDTO;

@Service
public class CmServiceImpl implements CmService {

	public CmServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<CMDTO>> validateAndSave(CMDTO cmdto) {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();
		Set<ConstraintViolation<CMDTO>> violations = validator.validate(cmdto);

		if (violations != null && !violations.isEmpty()) {
			System.out.println("violations are present,return violations");
			return violations;

		} else {
			System.out.println("violations are not present,data is good");

			return Collections.emptySet();
		}
	}

}
