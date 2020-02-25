package com.psych.game.auth;

import com.psych.game.exception.NoSuchUserException;
import com.psych.game.model.User;
import com.psych.game.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if(! user.isPresent()) {
            try {
                throw new NoSuchUserException("No User registered with email " + email);
            } catch (NoSuchUserException e) {
                e.printStackTrace();
            }
        }
        return new  CustomUserDetails(user.get());
    }


}
