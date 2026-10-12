package com.casestudy.bms;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.casestudy.bms.model.Feature;
import com.casestudy.bms.model.Movie;
import com.casestudy.bms.model.Region;
import com.casestudy.bms.model.Screen;
import com.casestudy.bms.model.Seat;
import com.casestudy.bms.model.SeatStatus;
import com.casestudy.bms.model.SeatType;
import com.casestudy.bms.model.Show;
import com.casestudy.bms.model.ShowSeat;
import com.casestudy.bms.model.ShowSeatType;
import com.casestudy.bms.model.Theater;
import com.casestudy.bms.model.User;
import com.casestudy.bms.repository.MovieRepository;
import com.casestudy.bms.repository.RegionRepository;
import com.casestudy.bms.repository.ScreenRepository;
import com.casestudy.bms.repository.SeatRepository;
import com.casestudy.bms.repository.SeatTypeRepository;
import com.casestudy.bms.repository.ShowRepository;
import com.casestudy.bms.repository.ShowSeatRepository;
import com.casestudy.bms.repository.ShowSeatTypeRepository;
import com.casestudy.bms.repository.TheaterRepository;
import com.casestudy.bms.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class BookmyshowSqlApplication implements CommandLineRunner{

	private final RegionRepository regionRepository;

	private final TheaterRepository theaterRepository;

	private final ScreenRepository screenRepository;

	private final SeatRepository seatRepository;

	private final ShowRepository showRepository;

	private final SeatTypeRepository seatTypeRepository;

	private final MovieRepository movieRepository;

	private final ShowSeatRepository showSeatRepository;

	private final ShowSeatTypeRepository showSeatTypeRepository;

	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookmyshowSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Save parents before children: every @ManyToOne target must already be persisted
		Region region = new Region();
		region.setName("Mumbai");
		regionRepository.save(region);

		Theater theater = new Theater();
		theater.setName("Maxus Mall");
		theater.setRegion(region);
		theaterRepository.save(theater);

		Screen screen1 = new Screen();
		screen1.setName("S1");
		screen1.setTheater(theater);
		screen1.setFeatures(List.of(Feature.THREE_D, Feature.DOLBY));
		screenRepository.save(screen1);

		SeatType type1 = new SeatType();
		type1.setSeatType("Premium");
		seatTypeRepository.save(type1);

		SeatType type2 = new SeatType();
		type2.setSeatType("Gold");
		seatTypeRepository.save(type2);

		Seat seat1 = new Seat();
		seat1.setNumber(11);
		seat1.setRow("R1");
		seat1.setColumn("C1");
		seat1.setSeatType(type1);
		seat1.setScreen(screen1);
		seatRepository.save(seat1);

		Seat seat2 = new Seat();
		seat2.setNumber(12);
		seat2.setRow("R1");
		seat2.setColumn("C2");
		seat2.setSeatType(type1);
		seat2.setScreen(screen1);
		seatRepository.save(seat2);

		Seat seat3 = new Seat();
		seat3.setNumber(21);
		seat3.setRow("R2");
		seat3.setColumn("C1");
		seat3.setSeatType(type2);
		seat3.setScreen(screen1);
		seatRepository.save(seat3);

		Seat seat4 = new Seat();
		seat4.setNumber(22);
		seat4.setRow("R2");
		seat4.setColumn("C2");
		seat4.setSeatType(type2);
		seat4.setScreen(screen1);
		seatRepository.save(seat4);

		Movie movie = new Movie();
		movie.setTitle("Dhrusham 3");
		movie.setLanguage("Hindi");
		movie.setFeatures(List.of(Feature.THREE_D, Feature.DOLBY));
		movieRepository.save(movie);

		Show showMorning = new Show();
		showMorning.setStartTime(getTomorrowMorningShow());
		showMorning.setEndTime(getTomorrowAfternoonShow());
		showMorning.setMovie(movie);
		showMorning.setFeatures(List.of(Feature.THREE_D, Feature.DOLBY));
		showMorning.setScreen(screen1);
		showRepository.save(showMorning);

		Show afternoonShow = new Show();
		afternoonShow.setStartTime(getTomorrowAfternoonShow());
		afternoonShow.setEndTime(getTomorrowEveningShow());
		afternoonShow.setMovie(movie);
		afternoonShow.setFeatures(List.of(Feature.THREE_D, Feature.DOLBY));
		afternoonShow.setScreen(screen1);
		showRepository.save(afternoonShow);

		Show eveningShow = new Show();
		eveningShow.setStartTime(getTomorrowEveningShow());
		eveningShow.setEndTime(getTomorrowNightShow());
		eveningShow.setMovie(movie);
		eveningShow.setFeatures(List.of(Feature.THREE_D, Feature.DOLBY));
		eveningShow.setScreen(screen1);
		showRepository.save(eveningShow);

		ShowSeat showMSeat1 = new ShowSeat();
		showMSeat1.setShow(showMorning);
		showMSeat1.setSeat(seat1);
		showMSeat1.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showMSeat1);

		ShowSeat showMSeat2 = new ShowSeat();
		showMSeat2.setShow(showMorning);
		showMSeat2.setSeat(seat2);
		showMSeat2.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showMSeat2);

		ShowSeat showMSeat3 = new ShowSeat();
		showMSeat3.setShow(showMorning);
		showMSeat3.setSeat(seat3);
		showMSeat3.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showMSeat3);

		ShowSeat showMSeat4 = new ShowSeat();
		showMSeat4.setShow(showMorning);
		showMSeat4.setSeat(seat4);
		showMSeat4.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showMSeat4);

		ShowSeat showASeat1 = new ShowSeat();
		showASeat1.setShow(afternoonShow);
		showASeat1.setSeat(seat1);
		showASeat1.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showASeat1);

		ShowSeat showASeat2 = new ShowSeat();
		showASeat2.setShow(afternoonShow);
		showASeat2.setSeat(seat2);
		showASeat2.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showASeat2);

		ShowSeat showASeat3 = new ShowSeat();
		showASeat3.setShow(afternoonShow);
		showASeat3.setSeat(seat3);
		showASeat3.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showASeat3);

		ShowSeat showASeat4 = new ShowSeat();
		showASeat4.setShow(afternoonShow);
		showASeat4.setSeat(seat4);
		showASeat4.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showASeat4);

		ShowSeat showESeat1 = new ShowSeat();
		showESeat1.setShow(eveningShow);
		showESeat1.setSeat(seat1);
		showESeat1.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showESeat1);

		ShowSeat showESeat2 = new ShowSeat();
		showESeat2.setShow(eveningShow);
		showESeat2.setSeat(seat2);
		showESeat2.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showESeat2);

		ShowSeat showESeat3 = new ShowSeat();
		showESeat3.setShow(eveningShow);
		showESeat3.setSeat(seat3);
		showESeat3.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showESeat3);

		ShowSeat showESeat4 = new ShowSeat();
		showESeat4.setShow(eveningShow);
		showESeat4.setSeat(seat4);
		showESeat4.setSeatStatus(SeatStatus.AVAILABLE);
		showSeatRepository.save(showESeat4);

		ShowSeatType showSeatMType1 = new ShowSeatType();
		showSeatMType1.setShow(showMorning);
		showSeatMType1.setSeatType(type1);
		showSeatMType1.setPrice(500);
		showSeatTypeRepository.save(showSeatMType1);

		ShowSeatType showSeatMType2 = new ShowSeatType();
		showSeatMType2.setShow(showMorning);
		showSeatMType2.setSeatType(type2);
		showSeatMType2.setPrice(800);
		showSeatTypeRepository.save(showSeatMType2);

		ShowSeatType showSeatAType1 = new ShowSeatType();
		showSeatAType1.setShow(afternoonShow);
		showSeatAType1.setSeatType(type1);
		showSeatAType1.setPrice(500);
		showSeatTypeRepository.save(showSeatAType1);

		ShowSeatType showSeatAType2 = new ShowSeatType();
		showSeatAType2.setShow(afternoonShow);
		showSeatAType2.setSeatType(type2);
		showSeatAType2.setPrice(800);
		showSeatTypeRepository.save(showSeatAType2);

		ShowSeatType showSeatEType1 = new ShowSeatType();
		showSeatEType1.setShow(eveningShow);
		showSeatEType1.setSeatType(type1);
		showSeatEType1.setPrice(500);
		showSeatTypeRepository.save(showSeatEType1);

		ShowSeatType showSeatEType2 = new ShowSeatType();
		showSeatEType2.setShow(eveningShow);
		showSeatEType2.setSeatType(type2);
		showSeatEType2.setPrice(800);
		showSeatTypeRepository.save(showSeatEType2);

		User user = new User();
		user.setName("Sumit");
		user.setEmail("sumit@example.com");
		user.setPassword("password123");
		userRepository.save(user);
	}

	public Date getTomorrowMorningShow() {
		return getTomorrowShowAt(6, 0);
	}

	public Date getTomorrowAfternoonShow() {
		return getTomorrowShowAt(14, 0);
	}

	public Date getTomorrowEveningShow() {
		return getTomorrowShowAt(18, 0);
	}

	public Date getTomorrowNightShow() {
		return getTomorrowShowAt(21, 30);
	}

	private Date getTomorrowShowAt(int hour, int minute) {
		ZoneId istZone = ZoneId.of("Asia/Kolkata");

		return Date.from(
    		LocalDate.now(istZone)
            .plusDays(1)
            .atTime(hour, minute)
            .atZone(istZone)
            .toInstant());
	}

}
