package com.xworkz.violation.service;

import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.violation.dto.ValentineDTO;
import com.xworkz.violation.entity.ValentineEntity;
import com.xworkz.violation.repository.ValentineRepository;

@Service
public class ValentineServiceImpl implements ValentineService {

	public ValentineServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Autowired
	private ValentineRepository repo;

	@Override
	public Set<ConstraintViolation<ValentineDTO>> ValidateAndSave(ValentineDTO dto) {

		Set<ConstraintViolation<ValentineDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);

		if (violations != null && !violations.isEmpty()) {
			System.err.println("violations present......invalid data");
			return violations;
		}

		System.out.println("no violations present,data can be saved");

		ValentineEntity entity = new ValentineEntity();
		entity.setName(dto.getName());
		entity.setValentineName(dto.getValentineName());
		entity.setMeetingPlace(dto.getMeetingPlace());
		entity.setGift(dto.getGift());

		boolean saved = repo.save(entity);
		System.out.println("data saved : " + saved);
		return Collections.emptySet();

	}

	@Override
	public ValentineDTO findById(int id) {
		if (id > 0) {
			ValentineEntity entity = repo.findById(id);
			if (entity != null) {
				System.out.println("entity is found for id : " + id);
				ValentineDTO dto = new ValentineDTO();
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setValentineName(entity.getValentineName());
				dto.setMeetingPlace(entity.getMeetingPlace());
				dto.setGift(entity.getGift());
				return dto;

			}
		}
		return ValentineService.super.findById(id);

	}

}
