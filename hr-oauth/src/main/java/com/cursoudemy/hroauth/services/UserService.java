package com.cursoudemy.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cursoudemy.hroauth.feignClient.UserFeignClient;
import com.cursoudemy.hroauth.model.User;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null) {
            throw new IllegalArgumentException("Email not found.");
        } else {
            return user;
        }
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByUsername(username).getBody();
        if (user == null) {
            throw new UsernameNotFoundException("Username not found.");
        } else {
            return user;
        }
    }
    
}
