package com.xworkz.violation.controller;

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

import com.xworkz.violation.dto.ValentineDTO;
import com.xworkz.violation.service.ValentineService;

@Controller
@RequestMapping("/")
public class ValentineController {

	public ValentineController() {
		System.out.println("created : " + this.getClass().getSimpleName());

	}

	@Autowired
	ValentineService service;

	List<String> meetingPlace = Arrays.asList("cubbon park", "ub city", "mg road", "airport road");
	List<String> gifts = Arrays.asList("novitec exhaust", "capristo", "gintani", "ipe");

	@GetMapping
	public String onFeb(Model model) {

		model.addAttribute("meetingPlace", meetingPlace);
		model.addAttribute("gifts", gifts);

		return "Valentine";

	}

	@PostMapping
	public String onFeb(ValentineDTO dto, Model model) {

		Set<ConstraintViolation<ValentineDTO>> violations = service.ValidateAndSave(dto);

		model.addAttribute("meetingPlace", meetingPlace);
		model.addAttribute("gifts", gifts);
		model.addAttribute("violations", violations);

		if (!violations.isEmpty()) {
			
			System.err.println("validation failed,display error message");
			violations.forEach((cv) -> {
				System.err.println(cv.getMessage());
			});
			return "Valentine";

		} else {
			System.out.println("validation success,display success message");

			return "Success";

		}
	}
	
	
	@GetMapping("/search")
	public String onSearch(@RequestParam Integer id,Model model) {
		ValentineDTO dto=service.findById(id);
		if(dto!=null) {
			model.addAttribute("dto", dto);
		}
		else {
			model.addAttribute("message", "no data found for id");
		}
		return "ValentineSearch";

		

	}

}
