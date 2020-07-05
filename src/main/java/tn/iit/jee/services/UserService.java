package tn.iit.jee.services;

import tn.iit.jee.models.User;
import tn.iit.jee.webDto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistrationDto registration);
}
