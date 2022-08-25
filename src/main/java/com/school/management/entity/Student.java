package com.school.management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity		// annotation to create table in DB using hibernate
@Table(name = "student_data")		// annotation to manually set table name in DB
public class Student {

	@Id		// annotation to specify primary key.
	@GeneratedValue(strategy = GenerationType.AUTO)		// annotation to make primary key auto generative.
	private int id;
	
	@Column(name = "student_name")		// annotation to manually set column name in table.
	private String name;
	private String number;
	private int marks;
	
//	---------------------------------------------------------------------------------------------------------------------------------
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Parent parent;
//	---------------------------------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------------------------------
	@ManyToOne	
//	@JsonIgnore
	private Standard standard;
//	---------------------------------------------------------------------------------------------------------------------------------

	
	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Student() {
		
	}
	
	public Student(int id, String name, String number, int marks, Parent parent, Standard standard) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.marks = marks;
		this.parent = parent;
		this.standard = standard;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", number=" + number + ", marks=" + marks + "]";
	}

	

	
}
