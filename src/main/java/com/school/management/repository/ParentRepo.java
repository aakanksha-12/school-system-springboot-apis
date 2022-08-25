package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.management.entity.Parent;

public interface ParentRepo extends JpaRepository<Parent, Long> {

}
