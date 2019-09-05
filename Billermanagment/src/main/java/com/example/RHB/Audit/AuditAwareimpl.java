package com.example.RHB.Audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditAwareimpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		// TODO Auto-generated method stub
		return Optional.of("Admin");//Hard coded instead use Spring security also
	}
	
	/*---Below code for Spring security--
	 *public class SpringSecurityAuditorAware implements AuditorAware<User> {

 public User getCurrentAuditor() {

  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

  if (authentication == null || !authentication.isAuthenticated()) {
   return null;
  }

  return ((MyUserDetails) authentication.getPrincipal()).getUser();
 }
	 */

}
