package com.xworkz.annotations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.annotations.dto.BakeryDTO;
import com.xworkz.annotations.service.BakeryService;

@Controller
@RequestMapping("/bake")
public class BakeryController {

	public BakeryController() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Autowired
	private BakeryService service;

	@PostMapping
	public String onBake(BakeryDTO dto, Model model) {
		model.addAttribute("bakery", dto);

		boolean saved = service.validateAndSave(dto);
		System.out.println("is dto valid and saved : " + saved);

		return "BakerySuccess.jsp";
	}

}
