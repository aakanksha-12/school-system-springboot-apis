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

import com.school.management.payload.StudentDto;
import com.school.management.payload.StudentDto2;
import com.school.management.services.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// API to create student
	@PostMapping("/")
	public StudentDto createStudent(@RequestBody StudentDto student) {
		StudentDto createStudent = this.studentService.createStudent(student);
		return createStudent;
	}

	// API to update student
	@PutMapping("/{id}")
	public StudentDto updateStudent(@RequestBody StudentDto student, @PathVariable("id") Integer id) {
		System.out.println("Controller" + student);
		StudentDto updatedStudent = this.studentService.updateStudent(student, id);
		return updatedStudent;
	}

	// API to get one student by ID
	@GetMapping("/{id}")
	public StudentDto getStudent(@PathVariable("id") Integer id) {
		StudentDto student = this.studentService.getOneStudentById(id);
		return student;
	}

	// API to get all students.
	@GetMapping("/")
	public List<StudentDto> getAllStudent() {
		List<StudentDto> allStudents = this.studentService.getAllStudents();
		return allStudents;
	}

	// API to delete student by ID.
	@SuppressWarnings("unchecked") // this annotation is totatly optional, ignore it.
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, String>> deleteStudent(@PathVariable("id") Integer id) {

		this.studentService.deleteStudentById(id);

		@SuppressWarnings("rawtypes") // this annotation is totatly optional, ignore it.
		Map response = new HashMap<>();
		response.put("message", "Student deleted successfully.");

		return new ResponseEntity<Map<String,String>>(response, HttpStatus.OK);
	}

	@PutMapping("/{studId}/p/{parentId}/s/{stdId}")
	 public StudentDto2 updateStudent2(@RequestBody StudentDto2 studentDto, @PathVariable("studId") Integer studId, @PathVariable("parentId") Long  pId,
			 @PathVariable("stdId") Long sId) {
		
			return this.studentService.updateStudent2(studentDto, studId, pId, sId);
	 }
	
	@PostMapping("/s/{stdId}")
	public StudentDto2 createStudent2(@RequestBody StudentDto2 studentDto, @PathVariable("stdId") Long stdId) {
		
		return this.studentService.createStudent2(studentDto, stdId);
	}
}
