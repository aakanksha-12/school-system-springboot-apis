package com.school.management.services;

import java.util.List;

import com.school.management.entity.Parent;

public interface ParentService {
	
	Parent createParent(Parent parent);
	
	Parent updateParent(Parent parent,Long id);
	
	void deleteParent(Long id);
	
	Parent getParent(Long id);
	
	List<Parent> getAllParent();
	
}
