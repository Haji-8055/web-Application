package com.xworkz.boot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.boot.dto.BootAppDTO;
import com.xworkz.boot.entity.BootAppEntity;
import com.xworkz.boot.repository.BootAppRepo;

@Service
public class BootAppServiceImpl implements BootAppService {

	@Autowired
	BootAppRepo repo;

	@Override
	public boolean onSave(BootAppDTO appDTO) {
		
		BootAppEntity appEntity = new BootAppEntity();

		BeanUtils.copyProperties(appDTO, appEntity);

		repo.save(appEntity);
		return true;
	}

}
