package com.school.management.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.management.payload.StandardDto;
import com.school.management.services.StandardService;

@RestController
@RequestMapping("/api/standard")
public class StandardController {

	@Autowired
	private StandardService standardService;

	@PostMapping("/")
	public StandardDto createStandardDto(@RequestBody StandardDto standardDto) {
		StandardDto createStandardDto = this.standardService.createStandardDto(standardDto);
		return createStandardDto;
	}

	@PutMapping("/{id}")
	public StandardDto updateStanadardDto(@RequestBody StandardDto standardDto, @PathVariable("id") Long id) {
		StandardDto updateStandardDto = this.standardService.updateStandardDto(standardDto, id);
		return updateStandardDto;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteStandardDto(@PathVariable("id") Long id) {
		this.standardService.deleteStandardDto(id);
		Map<String, String> response = new HashMap<>();

		response.put("message", "Standard is deleted");

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public StandardDto getStandardDto(@PathVariable("id") Long id) {
		StandardDto getStandardDto = this.standardService.getStandardDto(id);
		return getStandardDto;
	}

	@GetMapping("/")
	public List<StandardDto> getAllStandardDto() {
		List<StandardDto> allStandardDto = this.standardService.getAllStandardDto();
		return allStandardDto;
	}

//	----------------------------------------------------------------------------------------------------------------------------------

	@PutMapping("/{sId}/teacher/{tId}")
	public StandardDto changeTeacherOfStandard(@PathVariable("sId") Long sId, @PathVariable("tId") Integer tId) {
		
		StandardDto standardDto = this.standardService.assignNewClassTeacherForStandardDto(sId, tId);

		return standardDto;

	}
	
	@GetMapping("/s/{studId}")
	public StandardDto standardOfStudent(@PathVariable("studId") Integer studId) {
		
		return this.standardService.getStandardOfStudent(studId);
	}
}
