package com.school.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.entity.Parent;
import com.school.management.entity.Standard;
import com.school.management.entity.Student;
import com.school.management.payload.StudentDto;
import com.school.management.payload.StudentDto2;
import com.school.management.repository.ParentRepo;
import com.school.management.repository.StandardRepo;
import com.school.management.repository.StudentRepo;
import com.school.management.services.StudentService;

@Service // annotation to specify the service: It contains business logics.
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private ParentRepo parentRepo;

	@Autowired
	private StandardRepo standardRepo;

	@Autowired
	private ModelMapper modelMapper;

	// ------------------------------------------ Business logics of database
	// opetaions--------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------------------------
	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		// Student convertStudentDtoToStudent =
		// this.convertStudentDtoToStudent(student);
		Student student = this.modelMapper.map(studentDto, Student.class);
		Student saved = this.studentRepo.save(student);
		return this.modelMapper.map(saved, StudentDto.class);
		// return this.convertStudentToStudentDto(saved);
	}

	@Override
	public StudentDto updateStudent(StudentDto student, int id) {

		Student student1 = this.studentRepo.findById(id).get();

		if (student1 != null) {

			student1.setName(student.getName());
			student1.setMarks(student.getMarks());
			student1.setNumber(student.getNumber());
			student1.setParent(student.getParent());
			// student1.setStandard(student.getStandard());

			Student saved = this.studentRepo.save(student1);
			return this.modelMapper.map(saved, StudentDto.class);
		}
		return null;

	}

	@Override
	public StudentDto getOneStudentById(int id) {
		Student student = this.studentRepo.findById(id).get();
		return this.modelMapper.map(student, StudentDto.class);
	}

	@Override
	public void deleteStudentById(int id) {
//		Optional<Student> optionalUserData = this.studentRepo.findById(id);
//		Student student = optionalUserData.get();
//
//		this.studentRepo.delete(student);
//		------------------------------------------------------------------------------------------
		this.studentRepo.deleteById(id);

	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> studentDtos = students.stream().map((stud) -> this.modelMapper.map(stud, StudentDto.class))
				.collect(Collectors.toList());

		return studentDtos;
	}

	@Override
	public StudentDto2 updateStudent2(StudentDto2 studentDto2, Integer studId, Long parentId, Long stdId) {

		Student student = this.studentRepo.findById(studId).get();
		Parent parent = this.parentRepo.findById(parentId).get();
		Standard standard = this.standardRepo.findById(stdId).get();

		if (student != null) {
			student.setName(studentDto2.getName());
			student.setMarks(studentDto2.getMarks());
			student.setNumber(studentDto2.getNumber());

			if (parent != null) {
				parent.setName(studentDto2.getParent().getName());
				parent.setGender(studentDto2.getParent().getGender());
				parent.setMobno(studentDto2.getParent().getMobno());
				parent.setAddress(studentDto2.getParent().getAddress());
			}

			if (standard != null) {
				standard.setName(studentDto2.getStandard().getName());
			}

			student.setParent(parent);
			student.setStandard(standard);

			Student saved = this.studentRepo.save(student);
			return this.modelMapper.map(saved, StudentDto2.class);
		}
		return null;
	}

	@Override
	public StudentDto2 createStudent2(StudentDto2 studentDto2, Long stdId) {
		
		Standard standard = this.standardRepo.findById(stdId).get();
		
		Student student = this.modelMapper.map(studentDto2, Student.class);
		student.setStandard(standard);
		
		Student saved = this.studentRepo.save(student);
		StudentDto2 map = this.modelMapper.map(saved, StudentDto2.class);
		
		return map;
	}

//	-----------------------------------------------------------------------------------------------------------------------------------
//	private Student convertStudentDtoToStudent(StudentDto studentDto) {
//
//		Student student = new Student();
//
//		student.setId(studentDto.getId());
//		student.setName(studentDto.getName());
//		student.setMarks(studentDto.getMarks());
//		student.setNumber(studentDto.getNumber());
//		student.setParent(studentDto.getParent());
//		//student.setStandard(studentDto.getStandard());
//		
//		return student;
//	}
//
//	private StudentDto convertStudentToStudentDto(Student studentDto) {
//
//		StudentDto student = new StudentDto();
//
//		student.setId(studentDto.getId());
//		student.setName(studentDto.getName());
//		student.setMarks(studentDto.getMarks());
//		student.setNumber(studentDto.getNumber());
//		student.setParent(studentDto.getParent());
//		//student.setStandard(studentDto.getStandard());
//
//		return student;
//	}

}
