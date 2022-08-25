package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.entity.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}
