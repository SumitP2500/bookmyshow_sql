package com.casestudy.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Region
 */
@Getter 
@Setter 
public class Region extends BaseModel {
    private String name;
    private List<Theater> theaters;
}