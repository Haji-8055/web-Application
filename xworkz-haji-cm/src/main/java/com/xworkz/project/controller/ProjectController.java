package com.xworkz.project.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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

		log.info("running onSave in controller.........");

		List<ProjectDTO> dtos = service.fetchAllEntities();

		for (ProjectDTO d : dtos) {
			if (d.getUserId().equalsIgnoreCase(dto.getUserId())) {
				model.addAttribute("uniqueError", "user name already exist");
				model.addAttribute("dto", dto);

				return "SignUp";
			}
			if (d.getEmail().equalsIgnoreCase(dto.getEmail())) {
				model.addAttribute("uniqueError", "email already exist");
				model.addAttribute("dto", dto);

				return "SignUp";
			}
			if (d.getMobileNumber() == (dto.getMobileNumber())) {
				model.addAttribute("dto", dto);
				model.addAttribute("uniqueError", "mobile Number already exist");
				return "SignUp";
			}
		}

		if (!dto.getPassword().equals(dto.getConfirmPassword())) {
			model.addAttribute("confirmError", "confirm password and password is not same");
			model.addAttribute("dto", dto);
			return "SignUp";
		}

		Set<ConstraintViolation<ProjectDTO>> violations = service.validateAndSave(dto);
		log.info("dto" + dto);

		if (!violations.isEmpty()) {

			System.err.println("validation failed,display error message");
			violations.forEach((cv) -> {
				System.err.println(cv.getMessage());
				model.addAttribute("dto", dto);

				model.addAttribute("violations", violations);

			});
			return "SignUp";
		}

		else {

			log.info("validation success,display success message");
			model.addAttribute("successMessage", "SignUp successfull");
			return "index";
		}
	}

	@PostMapping("/SignIn")
	public String onSignIn(@RequestParam String userId, @RequestParam String password, Model model,
			HttpServletRequest request) {
		log.info("runnin onSignIn in controller.....");

		String msg = service.SignIn(userId, password);

		ProjectDTO dto = service.findByUserId(userId);

		if (msg.equals("")) {
			if (dto != null) {
				if (dto.getResetPassword() == true) {
					model.addAttribute("userId", dto.getUserId());
					return "UpdateNewPassword";
				}
			}

			HttpSession HttpSession = request.getSession(true);
			HttpSession.setAttribute("userId", userId);
			HttpSession.setAttribute("userImage", dto.getPicName());
			System.out.println(
					"=====================================================================" + dto.getPicName());

			model.addAttribute("successMessage", "welcome " + userId);
			return "SignInSuccess";
		}

		model.addAttribute("errorMessage", msg);
		return "SignIn";

	}

	@PostMapping("/forgotPassword")
	public String onForgotPassword(String email, Model model) {
		log.info("runnin onForgotPassword in controller.....");
		boolean passwordSent = service.sendRandomPassWord(email);

		if (passwordSent == true) {
			model.addAttribute("resetMsg", "reset password success please login");
			model.addAttribute("note", "NOTE : OTP is valid for 1 min");

			return "ForgotPassword";

		}

		model.addAttribute("resetError", "email id does not exist");

		return "ForgotPassword";
	}

	@PostMapping("/updatePassword")
	public String onUpdate(@RequestParam String userId, @RequestParam String password, Long mobileNumber, Model model) {
		log.info("running onUpdate in controller.....");
		log.info("new password entered by user in controller  ================" + password);

		ProjectDTO dto = service.findByUserId(userId);

		if (dto != null) {
			dto.setPassword(password);
			boolean updated = service.UpdateEntity(dto);
			log.info("password updated ??" + updated);
			model.addAttribute("updatedPassword", "please login with your updated password");
			return "SignIn";
		}
		model.addAttribute("error", "invalid password");
		return "UpdateNewPassword";

	}

	@GetMapping("/updateProfile")
	public String getProfileUpdate(@RequestParam String userId, Model model) {
		log.info("running update profile get mapping method.........");

		ProjectDTO dto = service.findByUserId(userId);
		model.addAttribute("dto", dto);
		return "UpdateProfile";
	}

	@PostMapping("/updateProfile")
	public String OnProfileUpdate(@RequestParam MultipartFile image, String email, String userId, Long mobileNumber,
			Model model, HttpServletRequest request) {
		ProjectDTO dto = service.findByEmailId(email);

		if (image.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "UpdateProfile";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = image.getBytes();
			Path path = Paths
					.get("E:\\coffee-images\\" + userId + System.currentTimeMillis() + image.getOriginalFilename());
			Files.write(path, bytes);
			dto.setPicName(path.getFileName().toString());
			dto.setUserId(userId);
			dto.setMobileNumber(mobileNumber);
			
			service.UpdateProfile(dto);
			
			System.out.println(
					"=====================================================================" + dto.getPicName());

		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpSession HttpSession = request.getSession(true);

		HttpSession.setAttribute("userId", dto.getUserId());
		HttpSession.setAttribute("userImage", dto.getPicName());
		model.addAttribute("dto", dto);
		model.addAttribute("updateSuccess", "profile updated successfully");
		return "UpdateProfile";
	}

	@GetMapping("/display")
	public void onDownload(HttpServletResponse response, @RequestParam String fileName, ProjectDTO dto)
			throws IOException {

		Path path = Paths.get("E:\\coffee-images\\" + dto.getPicName());
		path.toFile();
		response.setContentType("image/jpeg");
		File file = new File("E:\\coffee-images\\" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();
	}

}
