package com.casestudy.bms.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Movie
 */
@Getter 
@Setter 
@Entity 
public class Movie extends BaseModel{
    private String title;
    
    private String language;

    @OneToMany (mappedBy = "movie")
    List<Show> shows;
    
    @Enumerated(EnumType.STRING)
    private List<Feature> features;
}
