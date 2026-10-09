package com.casestudy.bms.model;

import lombok.Getter;
import lombok.Setter;

/**
 * User
 */
@Getter 
@Setter 
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}
