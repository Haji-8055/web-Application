package com.xworkz.plane.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.plane.dto.AeroplaneDTO;
import com.xworkz.plane.service.AeroplaneService;

@Controller
@RequestMapping("/")
public class AeroplaneController {

	List<String> type = Arrays.asList("fighter", "passenger", "cargo", "jet");

	List<String> country = Arrays.asList("india", "us", "usa", "russia");

	@Autowired
	private AeroplaneService service;

	public AeroplaneController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@GetMapping("/fly")
	public String onFly(Model model) {
		model.addAttribute("type", type);
		model.addAttribute("country", country);

		return "Aeroplane";
	}

	@PostMapping("/fly")
	public String onFly(AeroplaneDTO dto, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("country", country);
		Set<ConstraintViolation<AeroplaneDTO>> violations = service.validateAndSave(dto);
		if (!violations.isEmpty()) {
			model.addAttribute("violations", violations);
			System.out.println("validation failed display error  messages");
			violations.forEach((e) -> {
				System.out.println(e.getMessage());
			});
			return "Aeroplane";
		}
		System.out.println("validation success display success  messages");

		return "AeroplaneSuccess";
	}

	@GetMapping("/search")
	public String onSearch(@RequestParam int id, Model model) {
		
	AeroplaneDTO dto=service.findById(id);
	if(dto!=null) {
		model.addAttribute("dto", dto);
		return "AeroplaneSearch";

	}
	else {
		model.addAttribute("message", "*****data not found");
		return "AeroplaneSearch";

	}
		
	}
}
