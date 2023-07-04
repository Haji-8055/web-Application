package com.xworkz.project.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.entity.ProjectEntity;

public interface ProjectService {

	Set<ConstraintViolation<ProjectDTO>> validateAndSave(ProjectDTO dto);

	List<ProjectDTO> fetchAllEntities();
	
	String SignIn(String userId, String password);
	
	 boolean sendMail(String email,String subject,String msg);
	 
	boolean sendRandomPassWord(String email);
	
	ProjectDTO findByUserId(String userId);
	
	boolean UpdateEntity(ProjectDTO dto);
	
	boolean UpdateProfile(ProjectDTO dto);
	
	
	ProjectDTO findByEmailId(String email);
	
	public void expireOTP();
	
	

}
