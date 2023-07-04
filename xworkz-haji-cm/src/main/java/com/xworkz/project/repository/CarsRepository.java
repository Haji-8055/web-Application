package com.xworkz.project.repository;

import java.util.List;

import com.xworkz.project.entity.CarsEntity;

public interface CarsRepository {
	
	boolean save(CarsEntity entity);
	
	List<CarsEntity> findCar(String param,int id);


}
