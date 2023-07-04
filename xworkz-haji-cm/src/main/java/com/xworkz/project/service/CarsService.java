package com.xworkz.project.service;

import java.util.List;

import com.xworkz.project.dto.CarsDTO;
import com.xworkz.project.entity.CarsEntity;

public interface CarsService {
	
	boolean saveCars(CarsDTO carsDTO);

	List<CarsEntity> findCar(String userId,String param);
}
