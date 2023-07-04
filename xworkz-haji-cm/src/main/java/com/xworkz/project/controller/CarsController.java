package com.xworkz.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.project.dto.CarsDTO;
import com.xworkz.project.dto.ProjectDTO;
import com.xworkz.project.entity.CarsEntity;
import com.xworkz.project.service.CarsService;
import com.xworkz.project.service.ProjectService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/")
public class CarsController {
	

	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	CarsService carsService;

	public CarsController() {
		log.info("created : " + this.getClass().getSimpleName());
	}
	
	
	@PostMapping("/addCars")
	public String onAddCars(CarsDTO carsDTO ,Model model) {
	
		carsService.saveCars(carsDTO);
		
		model.addAttribute("msg", "car added successfully");
		
		return "AddCars";
	}
	
	@GetMapping("/ViewCars")
	public String onViewCars(String userId,Model model) {
	
		ProjectDTO dto=projectService.findByUserId(userId);
		
		
		List<CarsEntity> list=dto.getCarsEntities();
		
		model.addAttribute("list", list);
		
		return "ViewCars";
	}
	
	
	@PostMapping("/searchCar")
	public String onSearchCars(String userId,String param,Model model) {
		
		List<CarsEntity> carsEntities=carsService.findCar(userId, param);
		model.addAttribute("list", carsEntities);

		return "ViewCars";
	}
	
	

}
