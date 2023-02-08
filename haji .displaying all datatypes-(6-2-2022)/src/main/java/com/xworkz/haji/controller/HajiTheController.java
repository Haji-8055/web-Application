package com.xworkz.haji.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.haji.dto.EducationDTO;
import com.xworkz.haji.dto.FamilyDTO;
import com.xworkz.haji.dto.MobileDTO;

@Component
@RequestMapping("/")
public class HajiTheController {

	public HajiTheController() {
		System.out.println("created : " + this.getClass().getSimpleName());

	}

	@GetMapping("/mail")
	public String onEmail(Model model) {
		System.out.println("running onEmail method............");
		model.addAttribute("email", "murtuza.xworkz@gmail.com");
		return "index.jsp";
	}

	@GetMapping("/mobile")
	public String onMobile(Model model) {
		System.out.println("running onMobile method............");
		model.addAttribute("mobile", 719406887);
		return "index.jsp";
	}

	@GetMapping("/adhaar")
	public String onAdhaar(Model model) {
		System.out.println("running onAdhaar method............");
		model.addAttribute("adhaar", 509640233546l);
		return "index.jsp";
	}

	@GetMapping("/age")
	public String onAge(Model model) {
		System.out.println("running onAge method............");
		model.addAttribute("age", 21);
		return "index.jsp";
	}

	@GetMapping("/DOB")
	public String onDOB(Model model) {
		System.out.println("running onDOB method............");
		model.addAttribute("dateOFBirth", LocalDateTime.of(2000, 6, 6, 6, 30));
		return "index.jsp";
	}

	@GetMapping("/desiredSalary")
	public String onDesiredSalary(Model model) {
		System.out.println("running onDesiredSalary method............");
		model.addAttribute("desiredSalary", "7 crore");
		return "index.jsp";
	}

	@GetMapping("/bestFriends")
	public String onBestFriends(Model model) {
		System.out.println("running onBestFriends method............");
		List<String> list = new ArrayList<String>();
		list.add("furqan");
		list.add("ayaz");
		list.add("suhel");
		list.add("touqeer");
		list.add("zx10r");
		list.add("458 italia");
		list.add("huracan");
		list.add("aventador");
		list.add("812 superfast");
		list.add("s1000 rr");

		model.addAttribute("bestfriends", list);
		return "index.jsp";
	}

	@GetMapping("/mostVisitedPlace")
	public String onMostVisitedPlace(Model model) {
		System.out.println("running onMostVisitedPlace method............");
		List<String> list = new ArrayList<String>();
		list.add("ub city");
		list.add("vidyagiri");
		list.add("bangalore");
		list.add("bijapur");
		list.add("khazibudihal");
		list.add("navanagar");
		list.add("mg road");
		list.add("xworkz");
		list.add("bgmit");

		model.addAttribute("mostVisitedPlace", list);
		return "index.jsp";
	}

	@GetMapping("/skillSet")
	public String onSkillSet(Model model) {
		System.out.println("running onSkillSet method............");
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("html");
		list.add("css");
		list.add("bootstrap");
		list.add("javscript");
		list.add("spring");
		list.add("spring webMVC");
		list.add("servlet");
		list.add("server");

		model.addAttribute("skillSet", list);
		return "index.jsp";
	}

	@GetMapping("/educationDTO")
	public String onEducationDTO( Model model) {
		System.out.println("running onEducationDTO method............");
		EducationDTO dto=new EducationDTO();
		dto.setQualification("BE");
		dto.setDegreeCollege("bgmit");
		dto.setPucCollege("bvvs");
		dto.setSslcSchool("amar");
		dto.setDegreePercentage(65d);
		dto.setPucPercentage(52d);
		dto.setSslcPercentage(65d);
		dto.setDegreeBranch("mech");
		dto.setClgCity("bagalkot");
		dto.setHaveBacklogs(false);

		model.addAttribute("education", dto);
		
		return "index.jsp";
	}


	@GetMapping("/familyDTO")
	public String onFamilyDTO(Model model) {

		System.out.println("running onFamilyDTO method............");

		FamilyDTO dto=new FamilyDTO("ameer", "railway", "rahim", "bagalkot", 3.25d, 65.6d, 455, "pulsar", "sumo", 9449665643l);
		
//		dto.setFatherName("ameer");
//		dto.setFathersJob("railway");
//		dto.setBrotherName("rahim");
//		dto.setFamilyCity("bagalkot");
//		dto.setFathersIncome(3.25d);
//		dto.setFathersWt(65.6d);
//		dto.setCityDistance(455);
//		dto.setFathersBike("pulsar");
//		dto.setFathersCar("sumo");
//		dto.setMobileNumber(9449665643l);
	//	
		model.addAttribute("family", dto);

		return "index.jsp";
	}
	
	
	public String onMobileDTO(Model model) {

		System.out.println("running onFamilyDTO method............");

		MobileDTO dto=new MobileDTO();
		

		model.addAttribute("mobile", dto);

		return "index.jsp";
	}

}
