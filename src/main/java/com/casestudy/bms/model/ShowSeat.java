package com.casestudy.bms.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private SeatStatus seatStatus;
}
