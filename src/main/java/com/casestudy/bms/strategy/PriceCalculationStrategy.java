package com.casestudy.bms.strategy;

import java.util.List;

import com.casestudy.bms.model.ShowSeat;

public interface PriceCalculationStrategy {
    int calculatePrice(List<ShowSeat> showSeats);
}
