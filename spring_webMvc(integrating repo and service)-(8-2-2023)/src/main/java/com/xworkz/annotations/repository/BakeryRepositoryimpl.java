package com.xworkz.annotations.repository;

import org.springframework.stereotype.Repository;

import com.xworkz.annotations.dto.BakeryDTO;

@Repository
public class BakeryRepositoryimpl implements BakeryRepository {

	public BakeryRepositoryimpl() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(BakeryDTO dto) {
		System.out.println("running save method.");
		
		return false;
	}

}
