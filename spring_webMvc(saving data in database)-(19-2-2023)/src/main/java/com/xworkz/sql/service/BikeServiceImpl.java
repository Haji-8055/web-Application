package com.xworkz.sql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.sql.dto.BikeDTO;
import com.xworkz.sql.repository.BikeRepository;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	BikeRepository repository;

	public BikeServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public boolean validateAndSave(BikeDTO dto) {
		System.out.println("running validateAndSave method of BikeServiceImpl......");

		boolean saved = repository.save(dto);
		System.out.println("is data saved : " + saved);
		return true;
	}

}
