package com.school.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent_data")
public class Parent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "parent_name")
	private String name;

	@Column(name = "mobile_number")
	private String mobno;

	private String gender;
	private String address;
	
//	@OneToOne
//	@JsonIgnore
//	private Student student;

	public Parent() {

	}

	public Parent(long id, String name, String mobno, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobno = mobno;
		this.gender = gender;
		this.address = address;
//		this.student = student;
	}

//	public Student getStudent() {
//		return student;
//	}

//	public void setStudent(Student student) {
//		this.student = student;
//	}

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

	public String getMobno() {
		return mobno;
	}

	public void setMobno(String mobno) {
		this.mobno = mobno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
