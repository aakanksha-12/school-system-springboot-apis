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

import com.school.management.payload.SubjectDto;
import com.school.management.services.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PostMapping("/")
	public SubjectDto createSubject(@RequestBody SubjectDto subjectDto) {
		SubjectDto createSubjectDto = this.subjectService.createSubjectDto(subjectDto);
		return createSubjectDto;
	}

	@PutMapping("/{id}")
	public SubjectDto updateSubject(@RequestBody SubjectDto subjectDto, @PathVariable("id") Long id) {
		SubjectDto updatedSubjectDto = this.subjectService.updateSubjectDto(subjectDto, id);
		return updatedSubjectDto;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteSubject(@PathVariable("id") Long id) {
		this.subjectService.deleteSubjectDto(id);

		Map<String, String> response = new HashMap<>();

		response.put("message", "Standard is deleted");

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public SubjectDto getSubject(@PathVariable("id") Long id) {
		SubjectDto getSubjectDto = this.subjectService.getSubjectDto(id);
		return getSubjectDto;
	}

	@GetMapping("/")
	public List<?> getAllSubjects() {
		List<SubjectDto> allSubjectDto = this.subjectService.getAllSubjectDto();
		return allSubjectDto;
	}

}
