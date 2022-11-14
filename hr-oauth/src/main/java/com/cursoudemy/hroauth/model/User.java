package com.cursoudemy.hroauth.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long userID;
    private String name;
    private String username;
    private String email;
    private String password;
    private Set<Role> roles = new HashSet<>();
}
