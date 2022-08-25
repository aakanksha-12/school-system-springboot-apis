package com.school.management.payload;

public class SubjectDto {
	private long id;

	private String name;

	public SubjectDto(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SubjectDto() {
		
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
