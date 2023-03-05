package com.xworkz.annotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.annotations.dto.BakeryDTO;
import com.xworkz.annotations.repository.BakeryRepository;

@Service
public class BakeryServiceImpl implements BakeryService {

	public BakeryServiceImpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}
	
	@Autowired
	private BakeryRepository repo;

	@Override
	public boolean validateAndSave(BakeryDTO dto) {
		System.out.println("running validateAndSave.........");
		boolean saved=repo.save(dto);
		System.out.println("is dto saved : "+saved);
		return false;
	}

}
