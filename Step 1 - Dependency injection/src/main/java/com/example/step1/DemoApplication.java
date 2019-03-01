package com.example.step1;

import com.example.step1.trackcalculator.TrackCalculator;
import com.example.step1.trackrepository.TrackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackageClasses = {
				TrackRepository.class,
				TrackCalculator.class
		}
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
