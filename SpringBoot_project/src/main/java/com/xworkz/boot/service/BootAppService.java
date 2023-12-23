package com.xworkz.boot.service;

import java.util.List;
import java.util.Optional;

import com.xworkz.boot.dto.BootAppDTO;
import com.xworkz.boot.entity.BootAppEntity;

public interface BootAppService {

	public String onSave(BootAppDTO appDTO);

	public List<BootAppDTO> findAll();

	public Optional<BootAppEntity> findById(int id);
	
	public BootAppEntity update(BootAppDTO appDTO);
	public String delete(int id);
	
	public List<BootAppDTO> saveList(List<BootAppDTO> appDTOs);


}
