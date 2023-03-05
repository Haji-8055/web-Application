package com.xworkz.sql.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CMDTO {
	
	@NotBlank
	@NotNull
	@Size(min = 4 ,max = 20,message = "cm name should be greater than 4 and less than 20")
	private String cmName;
	
	@NotBlank(message = "state cannot be null,select state")
	@NotNull(message = "state cannot be null,select state")
	private String state;
	
	@NotBlank(message = "party cannot be null,select state")
	@NotNull(message = "party cannot be null,select party")
	private String party;
	
	
	@NotNull(message = "tenure cannot be null,select tenure")
	private Integer tenure;
	
	

}
