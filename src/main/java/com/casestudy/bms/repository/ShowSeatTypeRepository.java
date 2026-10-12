package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.ShowSeatType;

@Repository 
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long>{
        
}