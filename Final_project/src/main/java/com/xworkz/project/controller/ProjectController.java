package com.xworkz.project.controller;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class ProjectController {

	public ProjectController() {
		log.info("created : " + this.getClass().getSimpleName());

	}

	@Autowired
	ProjectService service;

	@PostMapping("/save")
	public String onSave(Model model, ProjectDTO dto) {

		log.info("running postMethod in controller.........");

		if (!dto.getPassword().equals(dto.getPassword())) {
			model.addAttribute("confirmError", "confirm password and password is not same");
			model.addAttribute("dto", dto);
			return "Register";

		}

		Set<ConstraintViolation<ProjectDTO>> violations = service.validateAndSave(dto);
		log.info("dto" + dto);

		if (!violations.isEmpty()) {

			System.err.println("validation failed,display error message");
			violations.forEach((cv) -> {
				System.err.println(cv.getMessage());

				model.addAttribute("violations", violations);

			});
			return "Register";
		}

		else {
			log.info("validation success,display success message");
			model.addAttribute("successMessage", "registered successfully");
			return "Register";
		}

	}
}
