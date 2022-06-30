package com.example.RomanNumeralGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RomanNumeralGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RomanNumeralGeneratorApplication.class, args);
		MainView mainView = new MainView();// maybe
	}

}
