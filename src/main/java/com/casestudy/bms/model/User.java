package com.casestudy.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
@Getter 
@Setter 
@Entity 
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}
