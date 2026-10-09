package com.casestudy.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Movie
 */
@Getter 
@Setter 
public class Movie {
    private String title;
    private String language;
    private List<Feature> features;
}
