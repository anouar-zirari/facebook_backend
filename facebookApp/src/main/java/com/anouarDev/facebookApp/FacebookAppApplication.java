package com.anouarDev.facebookApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FacebookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacebookAppApplication.class, args);
	}

}
