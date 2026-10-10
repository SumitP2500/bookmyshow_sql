package com.casestudy.bms.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Show
 */
@Getter 
@Setter 
@Entity(name="bms_show")
public class Show extends BaseModel{
    
    // show N : 1 movie
    @ManyToOne 
    private Movie movie;

    @ManyToOne 
    private Screen screen;

    private Date startTime;
    private Date endTime;

    @Enumerated (EnumType.STRING)
    private List<Feature> features;

}
