package com.ksi.tiakktiakk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = "com.ksi.tiakktiakk")
@EntityScan("com.ksi.tiakktiakk.model")
@EnableJpaRepositories(basePackages = "com.ksi.tiakktiakk.repository")
@SpringBootApplication
public class TiakkTiakkApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiakkTiakkApplication.class, args);
	}
}
