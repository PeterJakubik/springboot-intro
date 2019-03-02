package com.example.step3;

import com.example.step3.trackcalculator.TrackCalculator;
import com.example.step3.trackrepository.TrackRepository;
import com.example.step3.trackrepository.model.Track;
import com.example.step3.trackrepositoryapi.TrackRepositoryController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackageClasses = {
				TrackRepository.class,
				TrackCalculator.class,
				Track.class,
				TrackRepositoryController.class
		}
)
public class ApplicationStep3 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStep3.class, args);
	}

}
