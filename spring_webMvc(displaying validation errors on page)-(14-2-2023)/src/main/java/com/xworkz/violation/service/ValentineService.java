package com.xworkz.violation.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.violation.dto.ValentineDTO;

public interface ValentineService {
	
	Set<ConstraintViolation<ValentineDTO>> ValidateAndSave(ValentineDTO dto);
	
	default ValentineDTO findById(int id) {
		return null;
		
	}

}
