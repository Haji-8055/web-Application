package com.xworkz.project.repository;

import java.util.List;

import com.xworkz.project.entity.ProjectEntity;

public interface ProjectRepository {

	boolean save(ProjectEntity entity);
	
	List<ProjectEntity> uniqueCheck();

}
