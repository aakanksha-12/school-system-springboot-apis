package com.school.management.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.entity.Teacher;
import com.school.management.repository.TeacherRepo;
import com.school.management.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Override
	public Teacher createTeacher(Teacher teacher) {
		Teacher savedTeacher = this.teacherRepo.save(teacher);
		return savedTeacher;
	}

	@Override
	public Teacher updateTeacher(Teacher teacher, int id) {
		 Teacher teacher2 = this.teacherRepo.findById(id).get();
		
		if(teacher2 != null) {
			
			teacher2.setName(teacher.getName());
			teacher2.setMobno(teacher.getMobno());
			teacher2.setSalary(teacher.getSalary());
			
			Teacher updatedTeacher  = this.teacherRepo.save(teacher2);
			return updatedTeacher;
		}
		return null;
	}

	@Override
	public Teacher getOneTeacher(int id) {
		Optional<Teacher> optionalGetOneTeacher = this.teacherRepo.findById(id);
		Teacher getOneteacher = optionalGetOneTeacher.get();
		return getOneteacher;
	}

	@Override
	public void deleteTeacher(int id) {
		this.teacherRepo.deleteById(id);
		
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> getAllTeachers = this.teacherRepo.findAll();
		return getAllTeachers;
	}

}
