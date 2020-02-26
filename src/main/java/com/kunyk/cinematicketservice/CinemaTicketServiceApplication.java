package com.kunyk.cinematicketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CinemaTicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaTicketServiceApplication.class, args);
	}

}
