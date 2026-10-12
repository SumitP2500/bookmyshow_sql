package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.ShowSeat;

@Repository 
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
        
}