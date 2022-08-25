package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.entity.Student;

@Repository		// annotation to specify the repository: It is bridge betn server and DB
public interface StudentRepo extends JpaRepository<Student, Integer>{

}

