package com.school.management.controllers;

import java.util.HashMap;
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

import com.school.management.entity.Principal;
import com.school.management.services.PrincipalService;

@RestController
@RequestMapping("/api/principal")
public class PrincipalController {
	@Autowired
	private PrincipalService principalService;

	@PostMapping("/")
	public Principal createPrincipal(@RequestBody Principal principal) {
		Principal createPrincipal = this.principalService.createPrincipal(principal);
		return createPrincipal;
	}

	@PutMapping("/{id}")
	public Principal updatePrincipal(@RequestBody Principal principal, @PathVariable("id") Long id) {
		Principal updatePrincipal = this.principalService.updatePrincipal(principal, id);
		return updatePrincipal;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deletePrincipal(@PathVariable("id") Long id) {
		this.principalService.deletePrincipal(id);
		Map<String, String> response = new HashMap<>();

		response.put("message", "Principal is deleted");

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public Principal getPrincipal(@PathVariable("id")Long id) {
		Principal getPrincipal = this.principalService.getPrincipal(id);
		return getPrincipal;
	}

}
