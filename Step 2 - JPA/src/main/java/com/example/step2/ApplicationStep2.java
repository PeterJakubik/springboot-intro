package com.example.step2;

import com.example.step2.trackcalculator.TrackCalculator;
import com.example.step2.trackrepository.TrackRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackageClasses = {
				TrackRepository.class,
				TrackCalculator.class,
				com.example.step2.trackrepository.model.Track.class
		}
)
public class ApplicationStep2 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStep2.class, args);
	}

}
