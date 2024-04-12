package com.EMS.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class EmsH2DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsH2DatabaseApplication.class, args);
	}

}
