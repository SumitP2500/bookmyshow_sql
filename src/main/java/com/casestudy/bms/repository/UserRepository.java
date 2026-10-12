package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.bms.model.User;

@Repository 
public interface UserRepository extends JpaRepository<User, Long>{
        
}
