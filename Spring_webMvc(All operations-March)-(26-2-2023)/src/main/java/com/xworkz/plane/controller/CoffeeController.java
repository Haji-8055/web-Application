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

import com.xworkz.plane.dto.CoffeeDTO;
import com.xworkz.plane.service.CoffeeService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j public class CoffeeController {

	List<String> type = Arrays.asList("frappuccino", "espresso", "caffe latte", "cappuccino");

	List<String> outlet = Arrays.asList("mg road", "indira nagar", "ub city", "orion mall");

	@Autowired
	private CoffeeService service;

	public CoffeeController() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@GetMapping("/fly")
	public String onFly(Model model) {
		
		model.addAttribute("type", type);
		model.addAttribute("outlet", outlet);

		return "Coffee";
	}

	@PostMapping("/fly")
	public String onFly(CoffeeDTO dto, Model model) {
		
		model.addAttribute("type", type);
		model.addAttribute("outlet", outlet);
		
		Set<ConstraintViolation<CoffeeDTO>> violations = service.validateAndSave(dto);
		
		if (!violations.isEmpty()) {
			
			model.addAttribute("violations", violations);
			
			log.info("validation failed display error  messages");
			violations.forEach((e) -> {
				log.info(e.getMessage());
			});
			return "Coffee";
		}
		log.info("validation success display success  messages");

		return "CoffeeSuccess";
	}

	@GetMapping("/search")
	public String onSearch(@RequestParam int id, Model model) {

		CoffeeDTO dto = service.findById(id);
		if (dto != null) {
			model.addAttribute("dto", dto);
			return "CoffeeSearch";

		} else {
			model.addAttribute("message", "************data not found**************");
			return "CoffeeSearch";
		}
	}

	@GetMapping("/SearchByCom")
	public String companySearch(@RequestParam String company, Model model) {

		List<CoffeeDTO> dtos = service.findByCompanyName(company);
		if (dtos != null && !dtos.isEmpty()) {
			model.addAttribute("dto", dtos);
			return "CompanySearch";

		} else {
			model.addAttribute("message", "************data not found**************");
			return "CompanySearch";
		}
	}

	@GetMapping("/update")
	public String onUpdate(@RequestParam int id, Model model) {

		CoffeeDTO dto = service.findById(id);
		if (dto != null) {
			model.addAttribute("type", type);
			model.addAttribute("outlet", outlet);

			model.addAttribute("dto", dto);
		}
		return "Update";
	}

	@PostMapping("/update")
	public String onUpdate(CoffeeDTO dto, Model model) {

		model.addAttribute("type", type);
		model.addAttribute("outlet", outlet);

		Set<ConstraintViolation<CoffeeDTO>> violations = service.validateAndUpdate(dto);
		if (!violations.isEmpty()) {

			model.addAttribute("violations", violations);
			log.info("validation failed display error  messages");
			violations.forEach((e) -> {
				log.info(e.getMessage());
			});
			return "Update";
		}
		log.info("validation success display success  messages");

		model.addAttribute("message", "update of coffe detail success");
		return "Update";

	}

	@GetMapping("/delete")
	public String onDelete(@RequestParam int id, Model model) {

		boolean deleted = service.deleteById(id);
		
		model.addAttribute("deleted", "data deleted ? --" + deleted);

		return "CompanySearch";

	}

}
