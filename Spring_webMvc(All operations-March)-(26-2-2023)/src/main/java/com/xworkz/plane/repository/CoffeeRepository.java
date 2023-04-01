package com.xworkz.plane.repository;

import java.util.Collections;
import java.util.List;

import com.xworkz.plane.entity.CoffeeEntity;

public interface CoffeeRepository {

	boolean save(CoffeeEntity entity);

	CoffeeEntity findById(int id);

	default List<CoffeeEntity> findByCompanyName(String company) {

		return Collections.emptyList();
	}

	boolean update(CoffeeEntity entity);

	boolean deleteById(int id);

}
