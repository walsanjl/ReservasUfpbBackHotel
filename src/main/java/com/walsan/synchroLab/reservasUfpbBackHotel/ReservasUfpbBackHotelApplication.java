package com.walsan.synchroLab.reservasUfpbBackHotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservasUfpbBackHotelApplication implements CommandLineRunner {
	
	/*
	@Autowired
	private HotelRepository hotelRepository;
	*/
	
	public static void main(String[] args){
		SpringApplication.run(ReservasUfpbBackHotelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Hotel h1 = new Hotel(null, "Tambau", 5, "PB");
		Hotel h2 = new Hotel(null, "Copacabana Palace", 4, "RJ");
		Hotel h3 = new Hotel(null, "Plaza", 4, "SP");
		
		hotelRepository.saveAll(Arrays.asList(h1, h2, h3));
		*/
	}
}
