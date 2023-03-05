package com.xworkz.plane.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CoffeeDTO {
	
	private int id;
	
	@Size(min = 4, max = 30, message = "company name should be greater than 4 and less than 30")
	private String company;
	
	@Size(min = 4, max = 30, message = "name should be greater than 4 and less than 30")
	private String name;
	
	@NotNull(message = "quantity cannot be empty")
	@Min(value = 1,message = "quantity cannot be zero")
	private Integer quantity;
	
	@NotBlank(message = "type cannot be null")
	private String type;
	
	@NotBlank(message = "outlet cannot be null")
	private String outlet;

}
