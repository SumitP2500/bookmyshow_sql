package com.casestudy.bms.model;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class BaseModel {
    private int id;
    private Date createdAt;
    private Date updatedAt;
}
