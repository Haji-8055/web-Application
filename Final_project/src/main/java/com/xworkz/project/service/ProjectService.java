package com.xworkz.project.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.project.dto.ProjectDTO;

public interface ProjectService {

	Set<ConstraintViolation<ProjectDTO>> validateAndSave(ProjectDTO dto);

	List<ProjectDTO> uniqueCheck();

}
