package com.xworkz.model.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.model.dto.BeachDTO;

@Component
@RequestMapping("/swim")
public class BeachController {

	public BeachController() {
		System.out.println("created BeachController............");
	}
	
	@PostMapping
	public String onSwim(BeachDTO dto,Model model) {
		
		model.addAttribute("beachName", dto.getBeachName());
		model.addAttribute("location", dto.getLocation());
		model.addAttribute("isClean", dto.getIsClean());
		model.addAttribute("games", dto.getGames());
		
		return "BeachSuccess.jsp";
	}

}
