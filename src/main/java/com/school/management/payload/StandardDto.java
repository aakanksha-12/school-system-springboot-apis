package com.school.management.payload;

import java.util.ArrayList;
import java.util.List;

import com.school.management.entity.Teacher;

public class StandardDto {
	private long id;
	private String name;

	private Teacher classTeacher;

	private List<StudentDto> students = new ArrayList<>();

	public StandardDto() {

	}

	public StandardDto(long id, String name, Teacher classTeacher, List<StudentDto> students) {
		super();
		this.id = id;
		this.name = name;
		this.classTeacher = classTeacher;
		this.students = students;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDto> students) {
		this.students = students;
	}

	public Teacher getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(Teacher classTeacher) {
		this.classTeacher = classTeacher;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
