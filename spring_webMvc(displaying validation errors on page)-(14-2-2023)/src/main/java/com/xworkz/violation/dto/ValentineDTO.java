package com.xworkz.violation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ValentineDTO {
	
	private int id;


	@Size(min = 4, max = 30, message = "name should be greater than 4 and less than 30")
	private String name;

	@Size(min = 4, max = 30, message = "valentineName should be greater than 4 and less than 30")
	private String valentineName;
	
	@NotBlank(message = "meeting place cannot be null")
	private String meetingPlace;
	
	@NotBlank(message = "gift cannot be null")
	private String gift;

}
