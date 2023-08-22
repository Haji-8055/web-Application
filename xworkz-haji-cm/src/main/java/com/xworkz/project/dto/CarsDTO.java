package com.xworkz.project.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CarsDTO {
	//to find user using userid coming from frontend
	private String userId;

	private int carsId;
	
	@NotNull
	@Size(min = 3,max=25,message = "company name should be greater than 3 and less than 25")
	private String carCompany;

	private String carName;
	
	private String carModel;
	
	private int noOfOwners;
	
	private ProjectDTO projectDTO;
	
}
