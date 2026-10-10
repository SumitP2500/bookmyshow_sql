package com.casestudy.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * SeatType
 */
@Getter 
@Setter 
@Entity 
public class SeatType extends BaseModel{
    private String seatType;
}
