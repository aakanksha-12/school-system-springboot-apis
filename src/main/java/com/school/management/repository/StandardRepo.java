package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.entity.Standard;
import com.school.management.entity.Student;

@Repository
public interface StandardRepo extends JpaRepository<Standard, Long> {
	
	Standard findByStudents(Student students);
}
