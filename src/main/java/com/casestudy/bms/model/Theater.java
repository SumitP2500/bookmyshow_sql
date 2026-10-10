package com.casestudy.bms.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Theater
 */
@Getter 
@Setter 
@Entity 
public class Theater extends BaseModel{
    private String name;
    @ManyToOne
    private Region region;
    @OneToMany (mappedBy = "theater")
    private List<Screen> screens;
}
