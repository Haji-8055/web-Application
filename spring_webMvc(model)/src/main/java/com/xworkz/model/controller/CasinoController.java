package com.xworkz.model.controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.model.dto.CasinoDTO;

@Component
@RequestMapping("/play")
public class CasinoController {

	public CasinoController() {
		System.out.println("created CasinoController....");
	}
	

	@PostMapping
	public String onSubmit(CasinoDTO dto ,Model model) {
		
		model.addAttribute("casinoName", dto.getCasinoName());
		model.addAttribute("cruise", dto.getCruise());
		model.addAttribute("entryFee", dto.getEntryFee());
		model.addAttribute("freeFood", dto.getFreeFood());
		model.addAttribute("freeAlcohol", dto.getFreeAlcohol());
		
		return "CasinoSuccess.jsp";
	}
}
