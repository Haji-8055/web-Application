package com.xworkz.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.boot.entity.BootAppEntity;
import com.xworkz.boot.repository.BootAppRepo;

@Service
public class BootAppServiceImpl implements BootAppService {

	@Autowired
	BootAppRepo repo;

	@Override
	public boolean onSave(BootAppEntity entity) {
		repo.save(entity);
		return true;
	}

}
