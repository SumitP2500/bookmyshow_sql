package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.Movie;

@Repository 
public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}