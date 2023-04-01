
package com.xworkz.plane.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.plane.dto.CoffeeDTO;
import com.xworkz.plane.entity.CoffeeEntity;
import com.xworkz.plane.repository.CoffeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeRepository repository;

	public CoffeeServiceImpl() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<CoffeeDTO>> validateAndSave(CoffeeDTO dto) {

		Set<ConstraintViolation<CoffeeDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);
		if (!violations.isEmpty()) {
			log.info("violations present invalid data.....");
			return violations;
		}

		log.info("no violations data can be saved..........");
		CoffeeEntity entity = new CoffeeEntity();

		entity.setCompany(dto.getCompany());
		entity.setName(dto.getName());
		entity.setCost(dto.getQuantity());
		entity.setType(dto.getType());
		entity.setOutlet(dto.getOutlet());

		boolean saved = repository.save(entity);

		log.info("is data saved : " + saved);
		return Collections.emptySet();

	}

	@Override
	public CoffeeDTO findById(int id) {
		if (id > 0) {
			CoffeeEntity entity = repository.findById(id);
			if (entity != null) {
				log.info("entity is found for id : " + id);
				CoffeeDTO dto = new CoffeeDTO();
				dto.setCompany(entity.getCompany());
				dto.setName(entity.getName());
				dto.setQuantity(entity.getCost());
				dto.setType(entity.getType());
				dto.setOutlet(entity.getOutlet());
				dto.setId(entity.getId());
				return dto;
			}
		}

		return CoffeeService.super.findById(id);
	}

	@Override
	public List<CoffeeDTO> findByCompanyName(String company) {
		log.info("running findByCompanyName in service..  " + company);
		if (company != null && !company.isEmpty()) {

			List<CoffeeEntity> entities = repository.findByCompanyName(company);

			List<CoffeeDTO> coffeeDTOs = new ArrayList<CoffeeDTO>();

			for (CoffeeEntity entity : entities) {

				CoffeeDTO dto = new CoffeeDTO();

				dto.setId(entity.getId());
				dto.setCompany(entity.getCompany());
				dto.setName(entity.getName());
				dto.setQuantity(entity.getCost());
				dto.setType(entity.getType());
				dto.setOutlet(entity.getOutlet());

				coffeeDTOs.add(dto);

			}
			if (!coffeeDTOs.isEmpty()) {

				System.out
						.println("number of entites returned by findByCompanyName of repository : " + entities.size());
				log.info("number of dto's saved  : " + coffeeDTOs.size());
				return coffeeDTOs;
			}

		}

		System.err.println("invalid company name???????????????????????????????");
		return CoffeeService.super.findByCompanyName(company);
	}

	@Override
	public Set<ConstraintViolation<CoffeeDTO>> validateAndUpdate(CoffeeDTO dto) {
		log.info("running update method in service............");
		Set<ConstraintViolation<CoffeeDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);
		if (!violations.isEmpty()) {
			log.info("violations present invalid data.....");
			return violations;
		}

		log.info("no violations data can be updated..........");

		CoffeeEntity entity = new CoffeeEntity();

		entity.setCompany(dto.getCompany());
		entity.setName(dto.getName());
		entity.setCost(dto.getQuantity());
		entity.setType(dto.getType());
		entity.setOutlet(dto.getOutlet());

		boolean saved = repository.update(entity);

		log.info("is data saved : " + saved);
		return Collections.emptySet();

	}

	@Override
	public boolean deleteById(int id) {

		log.info("running delete by id method in service...........");

		boolean deleted = repository.deleteById(id);

		return deleted;
	}
}
