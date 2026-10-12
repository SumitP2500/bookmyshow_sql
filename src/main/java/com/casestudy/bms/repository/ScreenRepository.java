package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.Screen;

@Repository 
public interface ScreenRepository extends JpaRepository<Screen, Long>{
        
}