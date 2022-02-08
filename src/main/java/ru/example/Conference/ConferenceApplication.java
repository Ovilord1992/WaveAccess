package ru.example.Conference;

import org.aspectj.lang.annotation.Before;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.PrePersist;

@SpringBootApplication
public class ConferenceApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConferenceApplication.class, args);
	}

}
