
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

@Service
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeRepository repository;

	public CoffeeServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<CoffeeDTO>> validateAndSave(CoffeeDTO dto) {

		Set<ConstraintViolation<CoffeeDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);
		if (!violations.isEmpty()) {
			System.out.println("violations present invalid data.....");
			return violations;
		}

		System.out.println("no violations data can be saved..........");
		CoffeeEntity entity = new CoffeeEntity();

		entity.setCompany(dto.getCompany());
		entity.setName(dto.getName());
		entity.setCost(dto.getQuantity());
		entity.setType(dto.getType());
		entity.setOutlet(dto.getOutlet());

		boolean saved = repository.save(entity);

		System.out.println("is data saved : " + saved);
		return Collections.emptySet();

	}

	@Override
	public CoffeeDTO findById(int id) {
		if (id > 0) {
			CoffeeEntity entity = repository.findById(id);
			if (entity != null) {
				System.out.println("entity is found for id : " + id);
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
		System.out.println("running findByCompanyName in service..  " + company);
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
				System.out.println("number of dto's saved  : " + coffeeDTOs.size());
				return coffeeDTOs;
			}

		}

		System.err.println("invalid company name???????????????????????????????");
		return CoffeeService.super.findByCompanyName(company);
	}

	@Override
	public Set<ConstraintViolation<CoffeeDTO>> validateAndUpdate(CoffeeDTO dto) {
		System.out.println("running update method in service............");
		Set<ConstraintViolation<CoffeeDTO>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(dto);
		if (!violations.isEmpty()) {
			System.out.println("violations present invalid data.....");
			return violations;
		}

		System.out.println("no violations data can be updated..........");
		
		CoffeeEntity entity = new CoffeeEntity();
		
		entity.setCompany(dto.getCompany());
		entity.setName(dto.getName());
		entity.setCost(dto.getQuantity());
		entity.setType(dto.getType());
		entity.setOutlet(dto.getOutlet());

		boolean saved = repository.update(entity);

		System.out.println("is data saved : " + saved);
		return Collections.emptySet();

	}

	@Override
	public boolean deleteById(int id) {
		
		System.out.println("running delete by id method in service...........");

		boolean deleted=repository.deleteById(id);
		
		return deleted;
	}
}
