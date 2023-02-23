package com.xworkz.plane.repository;

import com.xworkz.plane.entity.AeroplaneEntity;

public interface AeroplaneRepository {
	
	
	boolean save(AeroplaneEntity entity);
	
	 AeroplaneEntity findById(int id) ;

}
