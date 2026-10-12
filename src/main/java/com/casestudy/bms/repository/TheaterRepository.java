package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.Theater;

@Repository 
public interface TheaterRepository extends JpaRepository<Theater, Long>{
        
}