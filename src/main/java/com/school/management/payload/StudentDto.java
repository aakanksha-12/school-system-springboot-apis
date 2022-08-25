package com.school.management.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.school.management.entity.Parent;

public class StudentDto {
	
	private int id;
	private String name;
	private String number;
	private int marks;
	
	private Parent parent;
	
	@JsonIgnore
	private StandardDto standard;
	
	public StudentDto() {
		
	}
	
	public StudentDto(int id, String name, String number, int marks, Parent parent) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.marks = marks;
		this.parent = parent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public StandardDto getStandard() {
		return standard;
	}

	public void setStandard(StandardDto standard) {
		this.standard = standard;
	}
	
}
