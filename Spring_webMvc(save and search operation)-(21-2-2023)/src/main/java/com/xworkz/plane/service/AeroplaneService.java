package com.xworkz.plane.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.plane.dto.AeroplaneDTO;

public interface AeroplaneService {

	
	Set<ConstraintViolation<AeroplaneDTO>> validateAndSave(AeroplaneDTO dto);
	
	
	default AeroplaneDTO findById(int id) {
		return null;
		
	}
}
