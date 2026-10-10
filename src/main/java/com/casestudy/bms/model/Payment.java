package com.casestudy.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Payment
 */
@Getter 
@Setter 
@Entity 
public class Payment extends BaseModel{
    @ManyToOne 
    private Ticket ticket;
    private String transactionId;
    @Enumerated (EnumType.STRING)
    private PaymentMode mode;
    private Integer amount;
    @Enumerated (EnumType.STRING)
    private PaymentStatus status;
}
