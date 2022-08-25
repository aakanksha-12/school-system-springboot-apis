package com.school.management.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.entity.Principal;
import com.school.management.repository.PrincipalRepo;
import com.school.management.services.PrincipalService;

@Service
public class PrincipalServiceImpl implements PrincipalService {

	@Autowired
	private PrincipalRepo principalRepo;

	@Override
	public Principal createPrincipal(Principal principal) {
		Principal createPrincipal = this.principalRepo.save(principal);
		return createPrincipal;
	}

	@Override
	public Principal updatePrincipal(Principal principal, Long id) {
		Principal principal2 = this.principalRepo.findById(id).get();

		if (principal2 != null) {
			
			principal2.setName(principal.getName());
			principal2.setMobno(principal.getMobno());
			principal2.setSalary(principal.getSalary());
			
			Principal updatedPrincipal = this.principalRepo.save(principal2);
			return updatedPrincipal;
		}
		return null;
	}

	@Override
	public Principal getPrincipal(Long id) {
		Optional<Principal> optionalGetPrincipal = this.principalRepo.findById(id);
		Principal getPrincipal = optionalGetPrincipal.get();
		return getPrincipal;
	}

	@Override
	public void deletePrincipal(Long id) {
		this.principalRepo.deleteById(id);

	}

}
