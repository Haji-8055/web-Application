package com.xworkz.boot.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xworkz.boot.dto.BootAppDTO;
import com.xworkz.boot.entity.BootAppEntity;
import com.xworkz.boot.service.BootAppService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class BootAppController {

	@Autowired
	private BootAppService service;

	

	public BootAppController() {
//		log.info("created : " + this.getClass().getSimpleName());
	}

	@GetMapping(value = "/run", produces = MediaType.APPLICATION_JSON_VALUE)
	public BootAppDTO onRun() {

		BootAppDTO appDTO = new BootAppDTO();
		appDTO.setName("haji");
		appDTO.setClg("BGMIT");
		appDTO.setMobileNo(7019406887l);

		return appDTO;
	}

	

	// create or save operation
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean onSave(@RequestBody BootAppDTO appDTO) {

		service.onSave(appDTO);

		return true;
	}
	
	//save all
	@PostMapping(value = "/saveAll", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean onSaveAll(@RequestBody List<BootAppDTO> appDTOs) {

		
		service.saveList(appDTOs);

		return true;
	}

	

	// read operation
	@GetMapping("/{id}")
	public ResponseEntity<BootAppEntity> findById(@PathVariable int id) {
		log.info("running find by id ......................");

		Optional<BootAppEntity> optional= service.findById(id);
		
		if(optional.isPresent())
		{
		return ResponseEntity.ok(optional.get());

		}
		
		return ResponseEntity.noContent().build();
	}

	// update operation
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public BootAppEntity onUpdate(@RequestBody BootAppDTO appDTO) {

		return service.update(appDTO);

	}

	// delete operation
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable int id) {

		return service.delete(id);

	}
	
	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<BootAppDTO> findAll() {
		log.info("running findAll......................");

		List<BootAppDTO> list = service.findAll();

		return list;
	}

}
