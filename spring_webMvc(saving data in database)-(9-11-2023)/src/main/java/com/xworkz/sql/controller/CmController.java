package com.xworkz.sql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.sql.dto.CMDTO;

import lombok.Data;

@Controller
@Data
@RequestMapping("/cm")
public class CmController {

	public CmController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onCM(CMDTO cmdto) {
		System.out.println(cmdto);
		return "CM";

	}

}
