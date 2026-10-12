package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.SeatType;

@Repository 
public interface SeatTypeRepository extends JpaRepository<SeatType, Long>{
        
}