package com.xworkz.violation.repository;

import com.xworkz.violation.entity.ValentineEntity;

public interface ValentineRepository {

	
	boolean save(ValentineEntity entity);
	
	ValentineEntity findById(int id);
}
