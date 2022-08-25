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

import com.school.management.entity.Parent;
import com.school.management.services.ParentService;

@RestController
@RequestMapping("/api/parent")
public class ParentController {
	
	@Autowired
	private ParentService parentService;
	
	@PostMapping("/")
	public Parent createParent(@RequestBody Parent parent) {
		
		Parent createdParent = this.parentService.createParent(parent);
		return createdParent;
	}
	
	@PutMapping("/{id}")
	public Parent updateParent(@RequestBody Parent parent, @PathVariable("id") Long id) {
		Parent updateParent = this.parentService.updateParent(parent, id);
		return updateParent;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String,String>> deleteParent(@PathVariable("id") Long id) {
		this.parentService.deleteParent(id);
		
		Map<String,String> response = new HashMap<>();
		response.put("message","Parent is deleted. ");		
		return new ResponseEntity<Map<String,String>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public Parent getParent(@PathVariable("id") Long id) {
		Parent parent = this.parentService.getParent(id);
		return parent;
	}
	
	@GetMapping("/")
	public List<Parent> getAllParent() {
	List<Parent> allParent = this.parentService.getAllParent();
	return allParent;
	}
}
