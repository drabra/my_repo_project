package com.iktpreobuka.draganindnevnik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan ({"com.server", "com.server.config"})
@EnableJpaRepositories
@EnableConfigurationProperties
public class DraganinDnevnikApplication {

	public static void main(String[] args) {
		SpringApplication.run(DraganinDnevnikApplication.class, args);
	}
}
