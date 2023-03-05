package com.xworkz.plane.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.plane.dto.CoffeeDTO;

public interface CoffeeService {

	Set<ConstraintViolation<CoffeeDTO>> validateAndSave(CoffeeDTO dto);

	default CoffeeDTO findById(int id) {
		return null;

	}

	default List<CoffeeDTO> findByCompanyName(String company) {

		return Collections.emptyList();
	}
	
	Set<ConstraintViolation<CoffeeDTO>> validateAndUpdate(CoffeeDTO dto);

	boolean deleteById(int id);

}
