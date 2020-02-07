package com.test.apicumpleanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.test.apicumpleanos")
public class ApicumpleanosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApicumpleanosApplication.class, args);
	}

}
