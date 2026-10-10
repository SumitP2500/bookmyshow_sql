package com.casestudy.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity 
public class ShowSeat extends BaseModel{
    // showSeat 1 : 1 show
    @ManyToOne 
    private Show show;
    @ManyToOne 
    private Seat seat;

    @ManyToOne 
    private Ticket ticket;
    
    private SeatStatus seatStatus;
}
