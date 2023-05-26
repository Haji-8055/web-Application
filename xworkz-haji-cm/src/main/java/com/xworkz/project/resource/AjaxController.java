package com.xworkz.project.resource;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@EnableWebMvc
@RestController
@RequestMapping("/")
@Slf4j
public class AjaxController {

	public AjaxController() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@Autowired
	ProjectService service;

	@GetMapping(value = "/uniqueUser/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onUser(@PathVariable String userId) {
		
		log.info("running onUser in ajax");
		List<ProjectDTO> dtos = service.fetchAllEntities();

		for (ProjectDTO d : dtos) {
			if (d.getUserId().equalsIgnoreCase(userId)) {
				return "user name already exist";
			}
		}
		return "";
	}

	@GetMapping(value = "/uniqueEmail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onEmail(@PathVariable String email) {
		List<ProjectDTO> dtos = service.fetchAllEntities();

		for (ProjectDTO d : dtos) {
			if (d.getEmail().equalsIgnoreCase(email)) {
				return "email already exist";
			}
		}
		return "";
	}

	@GetMapping(value = "/uniqueNumber/{mobile}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String onMobile(@PathVariable Long mobile) {
		log.info("running onMobile in ajax");
		List<ProjectDTO> dtos = service.fetchAllEntities();

		for (ProjectDTO d : dtos) {
			if (d.getMobileNumber().equals(mobile)) {
				return "number already exist";
			}
		}
		return "";
	}

}
