package com.dpk.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.dpk"})
public class SpringBootProjectRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectRestApplication.class, args);
	}

}
