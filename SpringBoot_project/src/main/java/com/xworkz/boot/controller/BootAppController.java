package com.xworkz.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.boot.dto.BootAppDTO;
import com.xworkz.boot.service.BootAppService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class BootAppController {

	@Autowired
	BootAppService appService;

	public BootAppController() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/run", produces = MediaType.APPLICATION_JSON_VALUE)
	public BootAppDTO onRun() {

		BootAppDTO appDTO = new BootAppDTO();
		appDTO.setName("haji");
		appDTO.setClg("BGMIT");
		appDTO.setMobileNo(7019406887l);
		
		return appDTO;
	}

	@PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean onSave(@RequestBody BootAppDTO appDTO) {
		
		appService.onSave(appDTO);

		return true;
	}

}
