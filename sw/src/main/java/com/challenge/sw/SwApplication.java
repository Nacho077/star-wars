package com.challenge.sw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SwApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwApplication.class, args);
	}

}
