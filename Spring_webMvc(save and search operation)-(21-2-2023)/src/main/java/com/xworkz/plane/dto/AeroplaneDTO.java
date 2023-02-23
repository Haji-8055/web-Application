package com.xworkz.plane.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AeroplaneDTO {
	
	
	@Size(min = 4, max = 30, message = "company name should be greater than 4 and less than 30")
	private String company;
	
	@Size(min = 4, max = 30, message = "name should be greater than 4 and less than 30")
	private String name;
	
	@NotNull(message = "price cannot be empty")
	@Min(value = 1,message = "price cannot be zero")
	private Integer cost;
	
	@NotBlank(message = "type cannot be null")
	private String type;
	
	@NotBlank(message = "country cannot be null")
	private String country;

}
