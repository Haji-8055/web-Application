package com.xworkz.project.service;

import java.beans.Beans;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.project.dto.CarsDTO;
import com.xworkz.project.entity.CarsEntity;
import com.xworkz.project.entity.ProjectEntity;
import com.xworkz.project.repository.CarsRepository;
import com.xworkz.project.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarsServiceImpl implements CarsService {

	public CarsServiceImpl() {
		log.info("created : " + this.getClass().getSimpleName());

	}

	@Autowired
	CarsRepository carsRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Override
	public boolean saveCars(CarsDTO carsDTO) {

		ProjectEntity entity = projectRepo.findByUserID(carsDTO.getUserId());

		CarsEntity carsEntity = new CarsEntity();

		BeanUtils.copyProperties(carsDTO, carsEntity);
		carsEntity.setProjectEntity(entity);

		carsRepo.save(carsEntity);

		return true;
	}

	@Override
	public List<CarsEntity> findCar(String userId, String param) {
		
		ProjectEntity entity=projectRepo.findByUserID(userId);
		int id=entity.getId();
		
		List<CarsEntity> list=carsRepo.findCar(param,id);
		return list;
	}

}
