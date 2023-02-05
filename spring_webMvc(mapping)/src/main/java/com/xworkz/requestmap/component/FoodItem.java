package com.xworkz.requestmap.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/eat")
public class FoodItem {

	
	public FoodItem() {
		System.out.println("created FoodItem component..............");
	}
	
	@PostMapping
	public String onSubmit(@RequestParam String name,@RequestParam String food,@RequestParam String range,@RequestParam String price) {
		
		System.out.println("name : "+name);
		System.out.println("food : "+food);
		System.out.println("range : "+range);
		System.out.println("price : "+price);
		
		return "food.jsp";

	}
}
