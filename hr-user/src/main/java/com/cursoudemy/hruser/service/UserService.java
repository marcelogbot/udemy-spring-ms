package com.cursoudemy.hruser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.hruser.model.User;
import com.cursoudemy.hruser.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service @Slf4j
public class UserService {

    @Autowired
    private UserRepository userR;

    public User findById(Long userId) {
        User user = userR.findById(userId).get();
        if(user != null) {
            log.info("User {} found!", user.getUsername());
        } else {
            log.info("User with ID {} not found!", userId);
        }
        return user;
    }

    public User findByEmail(String email) {
        User user = userR.findByEmail(email);
        if(user != null) {
            log.info("User {} found!", user.getUsername());
        } else {
            log.info("User with email {} not found!", email);
        }
        return user;
    }

    public User findByUsername(String username) {
        User user = userR.findByUsername(username);
        if(user != null) {
            log.info("User {} found!", user.getUsername());
        } else {
            log.info("User with username {} not found!", username);
        }
        return user;
    }


    
}
