package com.school.management.services;

import java.util.List;

import com.school.management.entity.Teacher;

public interface TeacherService {
	Teacher createTeacher(Teacher teacher);
	
	Teacher updateTeacher(Teacher teacher, int id);
	
	Teacher getOneTeacher(int id);
	
	void deleteTeacher(int id);
	
	List<Teacher> getAllTeachers();
}
