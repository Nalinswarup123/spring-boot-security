package io.nalinswarup.springsecurityjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new UserDetailsDemo(username);
        Optional<User> user = userRepository.findByUserName(username);
        return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User " + username + " does not exist"));
    }
}
