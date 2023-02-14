package com.xworkz.sql.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.sql.dto.CMDTO;
import com.xworkz.sql.service.CmService;

import lombok.Data;

@Controller
@Data
@RequestMapping("/cm")
public class CmController {

	@Autowired
	private CmService service;
	
	public CmController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onCM(CMDTO cmdto) {
		System.out.println("running onCm"+cmdto);
		Set<ConstraintViolation<CMDTO>> violations=service.validateAndSave(cmdto);
		
		if(!violations.isEmpty()) {
			System.err.println("validation failed,display error message");
			violations.forEach((cv)->{System.err.println(cv.getMessage());});
		}
		else {
			System.out.println("validation success,display success message");
		}
		return "CM";

	}

}
