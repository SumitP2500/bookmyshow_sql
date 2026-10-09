package com.casestudy.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Theater
 */
@Getter 
@Setter 
public class Theater extends BaseModel{
    private String name;
    private Region region;
    private List<Screen> screens;
}
