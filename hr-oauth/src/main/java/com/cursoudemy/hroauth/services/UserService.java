package com.cursoudemy.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursoudemy.hroauth.feignClient.UserFeignClient;
import com.cursoudemy.hroauth.model.User;

@Service
public class UserService {

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
    
}
