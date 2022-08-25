package com.school.management.services;

import com.school.management.entity.Principal;

public interface PrincipalService {
	Principal createPrincipal(Principal principal);
	
	Principal updatePrincipal(Principal principal, Long id);
	
	Principal getPrincipal(Long id);
	
	void deletePrincipal(Long id);
}
