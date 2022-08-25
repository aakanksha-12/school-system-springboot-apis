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

import com.school.management.entity.Teacher;
import com.school.management.services.TeacherService;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	@PostMapping("/")
	public Teacher createTeacher(@RequestBody Teacher teacher) {
		Teacher createTeacher = this.teacherService.createTeacher(teacher);
		return createTeacher;
	}

	@PutMapping("/{id}")
	public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Integer id) {
		Teacher updatedTeacher = this.teacherService.updateTeacher(teacher, id);
		return updatedTeacher;
	}

	@GetMapping("/{id}")
	public Teacher getOneTeacher(@PathVariable("id") Integer id) {
		Teacher getOneTeacher = this.teacherService.getOneTeacher(id);
		return getOneTeacher;
	}

	@GetMapping("/")
	public List<Teacher> getAllTeacher() {
		List<Teacher> allTeachers = this.teacherService.getAllTeachers();
		return allTeachers;
	}

	// @DeleteMapping("/{id}")
//	public void deleteTeacher(@PathVariable("id") Integer id) {
//		this.teacherService.deleteTeacher(id);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteTeacher(@PathVariable("id") Integer id) {
		this.teacherService.deleteTeacher(id);

		Map<String, String> response = new HashMap<>();
		response.put("message", "Teacher is deleted successfully.");

		return new ResponseEntity<Map<String, String>>(response, HttpStatus.OK);

	}
}
