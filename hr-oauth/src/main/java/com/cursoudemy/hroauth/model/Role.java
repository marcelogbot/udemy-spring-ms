package com.cursoudemy.hroauth.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long roleID;
    private String name;
    
}
