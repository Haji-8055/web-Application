package com.xworkz.project.dto;


import java.time.LocalTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ProjectDTO {

	private int signUpId;

	@NotNull
	@Size(min = 4, max = 14, message = "email should be greater than 4 and less than 14")
	private String userId;

	@NotNull
	@Size(min = 4, max = 50, message = "email should be greater than 6")
	private String email;

	@NotNull(message = "the number should start from 6 to 9 and must contain 10 numbers")
	@Min(value = 6000000000L, message = "the number should start from 6 to 9 and must contain 10 numbers")
	@Max(value = 9999999999L, message = "the number should start from 6 to 9 and must contain 10 numbers")
	private Long mobileNumber;

	@NotNull
	@Size(min = 4, max = 10, message = "password should be greater than 4 and less than 10")
	private String password;
	
	private String ConfirmPassword;

	private String agreement;

	private Integer SignInCount = 0;

	private Boolean resetPassword = false;
	
	private LocalTime otpRequestedTime;

	private Boolean otpExpired;

	private String picName;


}
