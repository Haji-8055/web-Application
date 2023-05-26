package com.xworkz.project.repository;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.entity.ProjectEntity;

public interface ProjectRepository {

	boolean save(ProjectEntity entity);
	
	List<ProjectEntity> fetchAllEntities();
	
	ProjectEntity findByUserID(String userId);

	
	 boolean updateEntity(ProjectEntity entity);
	 
		public void expireOTP();
		
		ProjectEntity findByEmailId(String email);


}
