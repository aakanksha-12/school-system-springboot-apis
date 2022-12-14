package com.school.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.management.entity.Principal;

@Repository
public interface PrincipalRepo extends JpaRepository<Principal, Long> {

}
