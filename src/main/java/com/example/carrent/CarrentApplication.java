package com.example.carrent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrentApplication.class, args);
	}


/*	@Override
	public void run(String... args) throws Exception {
		//read all
		Car car = repository.findByMark("Opel");
		System.out.println(car);
	}*/
}
