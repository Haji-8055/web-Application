package com.xworkz.project.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.entity.ProjectEntity;
import com.xworkz.project.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository repo;

	public ProjectServiceImpl() {
		log.info("created " + getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<ProjectDTO>> validateAndSave(ProjectDTO dto) {

		Set<ConstraintViolation<ProjectDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations present......invalid data");

			return violations;
		}

		log.info("no violations present,data can be saved");
		ProjectEntity entity = new ProjectEntity();
		BeanUtils.copyProperties(dto, entity);
		entity.setCreatedBy(dto.getUserId());
		boolean saved = repo.save(entity);
		log.info("data saved : " + saved);
		return Collections.emptySet();
	}

	@Override
	public List<ProjectDTO> uniqueCheck() {

		List<ProjectEntity> entities = repo.uniqueCheck();

		List<ProjectDTO> dtos = new ArrayList<ProjectDTO>();

		for (ProjectEntity entity : entities) {

			ProjectDTO dto = new ProjectDTO();
			BeanUtils.copyProperties(entity, dto);

			dtos.add(dto);
		}
		return dtos;
	}
}
