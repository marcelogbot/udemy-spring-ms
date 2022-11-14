package com.cursoudemy.hroauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cursoudemy.hroauth.model.User;
import com.cursoudemy.hroauth.services.UserService;

@RestController
@RequestMapping(path = "oauth")
public class UserController {

    @Autowired
    private UserService userS;

    @GetMapping("/search_user") 
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
    
        return ResponseEntity.ok(userS.findByEmail(email));
    }
    
}
