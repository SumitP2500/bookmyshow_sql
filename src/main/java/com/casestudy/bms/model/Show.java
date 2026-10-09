package com.casestudy.bms.model;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Show
 */
@Getter 
@Setter 
public class Show {
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private Date endTime;
    private List<Feature> features;

}
