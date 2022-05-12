package com.tbs.theatre.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.tbs.theatre" })
@EntityScan(basePackages = { "com.tbs.theatre.dal.entity" })
@EnableJpaRepositories(basePackages = { "com.tbs.theatre.dal.repository" })
public class TheatreservApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreservApplication.class, args);
	}

}
