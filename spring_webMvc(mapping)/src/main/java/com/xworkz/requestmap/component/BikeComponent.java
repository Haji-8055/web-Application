package com.xworkz.requestmap.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.requestmap.dto.BikeDTO;

@Component
@RequestMapping("/accelerate")
public class BikeComponent {
	
	public BikeComponent() {

		System.out.println("created BikeComponent.........");
	}
	
	
	@PostMapping
	public String onSubmit(BikeDTO dto) {
		System.out.println("running onSubmit........");
		System.out.println("bike info : "+dto);
		
		return "bike.jsp";
	}

}
