package com.xworkz.plane.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.plane.dto.AeroplaneDTO;
import com.xworkz.plane.entity.AeroplaneEntity;
import com.xworkz.plane.repository.AeroplaneRepository;

@Service
public class AeroplaneServiceImpl implements AeroplaneService {

	@Autowired
	private AeroplaneRepository repository;

	public AeroplaneServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<AeroplaneDTO>> validateAndSave(AeroplaneDTO dto) {
		Set<ConstraintViolation<AeroplaneDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);
		if (!violations.isEmpty()) {
			System.out.println("violations present invalid data.....");
			return violations;
		}

		System.out.println("no violations data can be saved..........");
		AeroplaneEntity entity = new AeroplaneEntity();

		entity.setCompany(dto.getCompany());
		entity.setName(dto.getName());
		entity.setCost(dto.getCost());
		entity.setType(dto.getType());
		entity.setCountry(dto.getCountry());

		boolean saved = repository.save(entity);
		System.out.println("is data saved : " + saved);
		return Collections.emptySet();

	}

	@Override
	public AeroplaneDTO findById(int id) {
		if (id > 0) {
			AeroplaneEntity entity = repository.findById(id);
			if (entity != null) {
				System.out.println("entity is found for id : " + id);
				AeroplaneDTO dto = new AeroplaneDTO();
				dto.setCompany(entity.getCompany());
				dto.setName(entity.getName());
				dto.setCost(entity.getCost());
				dto.setType(entity.getType());
				dto.setCountry(entity.getCountry());
				return dto;
			}
		}

		return AeroplaneService.super.findById(id);
	}
}
