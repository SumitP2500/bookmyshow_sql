package com.casestudy.bms.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Payment
 */
@Getter 
@Setter 
public class Payment extends BaseModel{
    private String transactionId;
    private PaymentMode mode;
    private Integer amount;
    private PaymentStatus status;
}
