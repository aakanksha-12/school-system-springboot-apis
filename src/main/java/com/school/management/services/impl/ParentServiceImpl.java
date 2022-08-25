package com.school.management.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.entity.Parent;
import com.school.management.repository.ParentRepo;
import com.school.management.services.ParentService;

@Service
public class ParentServiceImpl implements ParentService {

	@Autowired
	private ParentRepo parentRepo;
	
	@Override
	public Parent createParent(Parent parent) {
		Parent createParent = this.parentRepo.save(parent);
		return createParent;
	}

	@Override
	public Parent updateParent(Parent parent, Long id) {
		Parent parent2 = this.parentRepo.findById(id).get();
		
		if(parent2 != null) {
			
			parent2.setName(parent.getName());
			parent2.setAddress(parent.getAddress());
			parent2.setGender(parent.getGender());
			parent2.setMobno(parent.getMobno());
			
			Parent parent1 = this.parentRepo.save(parent2);
			return parent1;
		}
		return null;
	}

	@Override
	public void deleteParent(Long id) {
		this.parentRepo.deleteById(id);

	}

	@Override
	public Parent getParent(Long id) {
		 Parent parent = this.parentRepo.findById(id).get();
		return parent;
	}

	@Override
	public List<Parent> getAllParent() {
		List<Parent> findAllParent = this.parentRepo.findAll();
		return findAllParent;
	}

}
