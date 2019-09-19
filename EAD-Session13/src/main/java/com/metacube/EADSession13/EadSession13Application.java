package com.metacube.EADSession13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EadSession13Application {

	public static void main(String[] args) {
		SpringApplication.run(EadSession13Application.class, args);
	}

}
