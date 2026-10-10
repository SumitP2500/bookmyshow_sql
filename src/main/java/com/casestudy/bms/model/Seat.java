package com.casestudy.bms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Seat
 */
@Getter 
@Setter 
@Entity 
public class Seat extends BaseModel {
    private Integer number;

    @Column (name = "bms_row")
    private String row;

    @Column (name="bms_column")
    private String column;

    @ManyToOne 
    private Screen screen;
    
    @OneToOne
    private SeatType seatType;

}
