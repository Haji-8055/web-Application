package com.xworkz.plane.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class ImageUploadController {

	public ImageUploadController() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@PostMapping("/upload") // //new annotation since 4.3
	public String singleFileUpload(@RequestParam MultipartFile image, Model model) {

		if (image.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "ImageUpload";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = image.getBytes();
			Path path = Paths.get("E:\\coffee-images\\" + image.getOriginalFilename());
			Files.write(path, bytes);

			model.addAttribute("message", "You successfully uploaded '");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ImageUpload";
	}

	@GetMapping("/display")
	public void onDownload(HttpServletResponse response, @RequestParam String fileName) throws IOException {
		response.setContentType("image/jpeg");
		File file = new File("E:\\coffee-images\\" + fileName);
		InputStream in = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		response.flushBuffer();
	}
}
