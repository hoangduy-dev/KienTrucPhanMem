package com.tuan4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tuan4.chuyenbay.model.ChuyenBay;
import com.tuan4.chuyenbay.repository.ChuyenBayRepository;

@SpringBootApplication
public class ThTuan4Application {
	private static final Logger log = LoggerFactory.getLogger(ThTuan4Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ThTuan4Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(ChuyenBayRepository repository) {
		 return (args) -> {
			 for (ChuyenBay chuyenBay : repository.findAll()) {
			        log.info(chuyenBay.toString());
			    }
		 };
	}

}
