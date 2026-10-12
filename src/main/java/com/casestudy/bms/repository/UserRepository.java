package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bms.model.User;

/** No @Repository needed: Spring Data scans interfaces extending JpaRepository and registers a proxy bean for each. */
public interface UserRepository extends JpaRepository<User, Long>{
        
}
