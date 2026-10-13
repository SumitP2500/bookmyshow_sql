package com.casestudy.bms.strategy;

import java.util.List;

import org.springframework.stereotype.Component;

import com.casestudy.bms.model.ShowSeat;
import com.casestudy.bms.repository.ShowSeatTypeRepository;

@Component 
public class PriceCalculationStrategyImpl implements PriceCalculationStrategy{

    final ShowSeatTypeRepository showSeatTypeRepository;

    PriceCalculationStrategyImpl(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    @Override
    public int calculatePrice(List<ShowSeat> showSeats) {
        int total=0;
        for(ShowSeat showSeat : showSeats) {
            int price = showSeatTypeRepository.findByShowAndSeatType(showSeat.getShow(), showSeat.getSeat().getSeatType());
            total+=price;
        }
        return total;
    }
}
