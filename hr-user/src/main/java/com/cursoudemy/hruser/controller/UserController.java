package com.cursoudemy.hruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.hruser.model.User;
import com.cursoudemy.hruser.repositories.UserRepository;

@RestController
@RequestMapping(path = "user")
public class UserController {

    @Autowired
    private UserRepository userR;

    @GetMapping("{userId}")
    public ResponseEntity<User> findById(@PathVariable Long userId) {
        return ResponseEntity.ok(userR.findById(userId).get());
    }

    @GetMapping("/findbyemail")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userR.findByEmail(email));
    }

    @GetMapping("/findbyusername")
    public ResponseEntity<User> findByUsername(@RequestParam String username) {
        return ResponseEntity.ok(userR.findByUsername(username));
    }

    
}
