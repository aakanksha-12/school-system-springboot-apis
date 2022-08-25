package com.school.management.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "standard_data")
public class Standard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
//	---------------------------------------------------------------------------------------------------------------------------------
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Teacher classTeacher;
//	---------------------------------------------------------------------------------------------------------------------------------

//	---------------------------------------------------------------------------------------------------------------------------------
	@OneToMany(mappedBy = "standard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<Student>();
//	---------------------------------------------------------------------------------------------------------------------------------

	public Standard() {

	}

	public Standard(long id, String name, Teacher classTeacher, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.classTeacher = classTeacher;
		this.students = students;
	}
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
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
