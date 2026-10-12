package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bms.model.ShowSeat;

/** No @Repository needed: Spring Data scans interfaces extending JpaRepository and registers a proxy bean for each. */
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long>{
        
}