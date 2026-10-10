package com.casestudy.bms.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Screen
 */
@Getter 
@Setter 
@Entity 
public class Screen extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
    @OneToMany(mappedBy = "screen")
    private List<Show> shows;
    @ManyToOne
    private Theater theater;
    @Enumerated (EnumType.STRING)
    private List<Feature> features;
}
