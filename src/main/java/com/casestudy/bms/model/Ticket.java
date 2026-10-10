package com.casestudy.bms.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
@Entity 
public class Ticket extends BaseModel{
    private Long ticketNumber;

    // ticket 1 : n showSeat
    @OneToMany (mappedBy = "ticket")
    private List<ShowSeat> showSeat;

    private Integer amount;
    
    @ManyToOne 
    private User user;

    @OneToMany (mappedBy = "ticket")
    private List<Payment> payments;

    @Enumerated (EnumType.STRING)
    private TicketStatus status;
}
