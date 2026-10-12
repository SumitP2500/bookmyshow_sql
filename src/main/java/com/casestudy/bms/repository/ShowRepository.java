package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.Show;

@Repository 
public interface ShowRepository extends JpaRepository<Show, Long> {

}
