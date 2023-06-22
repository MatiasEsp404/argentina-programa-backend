package com.matias.argentinaprograma.config.security.util;

import com.matias.argentinaprograma.config.security.common.Role;
import com.matias.argentinaprograma.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

  @Autowired
  private IUserRepository userRepository;

  public Authentication getAuthentication() {
    return SecurityContextHolder.getContext().getAuthentication();
  }

  public UserDetails getUserAuthenticated() {
    Object principal = getAuthentication().getPrincipal();
    String username;
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    } else {
      username = principal.toString();
    }
    return userRepository.findByEmail(username);
  }

  public boolean hasAdminRole() {
    return getAuthentication().getAuthorities().stream()
        .anyMatch(grantedAuthority -> Role.ADMIN.getFullRoleName()
            .equals(grantedAuthority.getAuthority()));
  }

}
