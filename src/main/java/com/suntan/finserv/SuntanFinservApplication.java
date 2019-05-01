package com.suntan.finserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SuntanFinservApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuntanFinservApplication.class, args);
	}

}
