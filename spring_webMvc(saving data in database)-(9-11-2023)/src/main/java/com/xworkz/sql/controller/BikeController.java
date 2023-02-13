package com.xworkz.sql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.sql.dto.BikeDTO;
import com.xworkz.sql.service.BikeService;

@Controller
@RequestMapping("/race")
public class BikeController {

	@Autowired
	BikeService service;

	public BikeController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@PostMapping
	public String onRace(BikeDTO dto) {

		System.out.println(dto);

		boolean valid = service.validateAndSave(dto);
		System.out.println("is data valid : " + valid);

		return "index";
	}
}
