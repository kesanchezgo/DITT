package com.ditt.innocheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.ditt.innocheck.models")
@EnableJpaRepositories(basePackages = "com.ditt.innocheck.repositories")
public class InnocheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnocheckApplication.class, args);
	}

}
