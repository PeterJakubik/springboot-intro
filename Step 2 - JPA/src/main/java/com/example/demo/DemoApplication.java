package com.example.demo;

import com.example.demo.trackcalculator.TrackCalculator;
import com.example.demo.trackrepository.TrackRepository;
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
