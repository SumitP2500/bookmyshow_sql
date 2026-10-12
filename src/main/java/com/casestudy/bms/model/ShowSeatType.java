package com.casestudy.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
public class ShowSeatType extends BaseModel{
    @ManyToOne 
    private Show show;
    @ManyToOne 
    private SeatType seatType;
    private Integer price;
}
