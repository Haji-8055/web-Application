package com.xworkz.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public String onSave(BootAppDTO appDTO) {

		BootAppEntity appEntity = new BootAppEntity();

		BeanUtils.copyProperties(appDTO, appEntity);

		repo.save(appEntity);
		return "entity saved";
	}

	@Override
	public List<BootAppDTO> findAll() {
		List<BootAppEntity> appEntities = repo.findAll();
		List<BootAppDTO> dtos = new ArrayList<BootAppDTO>();

		for (BootAppEntity Entity : appEntities) {

			BootAppDTO appDTO = new BootAppDTO();
			BeanUtils.copyProperties(Entity, appDTO);
			dtos.add(appDTO);

		}
		return dtos;
	}

	@Override
	public Optional<BootAppEntity> findById(int id) {
		return repo.findById(id);

	}

	@Override
	public String delete(int id) {

		BootAppEntity entity = repo.getOne(id);
		repo.delete(entity);
		return "deleted";
	}

	@Override
	public BootAppEntity update(BootAppDTO appDTO) {
		BootAppEntity appEntity = new BootAppEntity();

		BeanUtils.copyProperties(appDTO, appEntity);

		repo.save(appEntity);
		return appEntity;
	}

	@Override
	public List<BootAppDTO> saveList(List<BootAppDTO> appDTOs) {

		List<BootAppEntity> appEntities = appDTOs.stream().map(dto -> {
			BootAppEntity appEntity = new BootAppEntity();
			BeanUtils.copyProperties(dto, appEntity);
			return appEntity;
		}).collect(Collectors.toList());
		repo.saveAll(appEntities);
		return appDTOs;
	}

}
