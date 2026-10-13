package com.casestudy.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.casestudy.bms.model.Seat;
import com.casestudy.bms.model.SeatType;
import com.casestudy.bms.model.Show;
import com.casestudy.bms.model.ShowSeatType;

// //Because @Repository isn't what makes it work here. Spring Data JPA does it.

// How the bean gets created

// ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long>.
// Spring Boot's auto-configuration (@SpringBootApplication → @EnableAutoConfiguration → JpaRepositoriesAutoConfiguration) turns on repository scanning.
// That scan starts from the package of your main class, com.casestudy.bms, and includes subpackages like com.casestudy.bms.repository.
// It finds every interface that extends a Spring Data repository interface and generates a proxy implementation for each, such as SimpleJpaRepository. It then registers that proxy as a bean.
// @Autowired in the main class asks for a bean of type ShowSeatTypeRepository, and that proxy is it.
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {

    int findByShowAndSeatType(Show show, SeatType seatType);
        
}