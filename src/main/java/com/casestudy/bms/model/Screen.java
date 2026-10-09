package com.casestudy.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Screen
 */
@Getter 
@Setter 
public class Screen extends BaseModel {
    private String name;
    private List<Seat> seats;
    private List<Show> shows;
    private Theater theater;
    private List<Feature> features;
}
