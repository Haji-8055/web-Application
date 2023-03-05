package com.xworkz.sql.service;

import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.sql.dto.CMDTO;

public interface CmService {
	
	Set<ConstraintViolation<CMDTO>> validateAndSave(CMDTO cmdto);

}
