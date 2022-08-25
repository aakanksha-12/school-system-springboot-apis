package com.school.management.payload;

import com.school.management.entity.Parent;
import com.school.management.entity.Standard;

public class StudentDto2 {
	private int id;
	private String name;
	private String number;
	private int marks;
	
	private Parent parent;
	
	private Standard standard;
	
	public StudentDto2() {
		
	}
	
	public StudentDto2(int id, String name, String number, int marks, Parent parent) {
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

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}	
	
	
	
}