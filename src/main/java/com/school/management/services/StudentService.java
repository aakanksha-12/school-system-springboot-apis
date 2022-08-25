package com.school.management.services;

import java.util.List;

import com.school.management.payload.StudentDto;
import com.school.management.payload.StudentDto2;

public interface StudentService {
	
	StudentDto createStudent(StudentDto StudentDto);
	
	StudentDto updateStudent(StudentDto StudentDto, int id);
	
	StudentDto getOneStudentById(int id);
	
	void deleteStudentById(int id);
	
 	List<StudentDto> getAllStudents();
 	
 	StudentDto2 updateStudent2(StudentDto2 studentDto2, Integer studId, Long parentId, Long stdId);
 	
 	StudentDto2 createStudent2(StudentDto2 studentDto2,Long stdId);
 	
 	
 	
 
}
