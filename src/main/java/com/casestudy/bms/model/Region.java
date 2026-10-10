package com.casestudy.bms.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Region
 */
@Getter 
@Setter 
@Entity 
public class Region extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "region")
    private List<Theater> theaters;
}