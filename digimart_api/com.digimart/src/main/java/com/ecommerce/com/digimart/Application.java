package com.ecommerce.com.digimart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.ecommerce.com.digimart.*")
@EnableJpaRepositories("com.ecommerce.com.digimart.*")
@ComponentScan(basePackages = {"com.ecommerce.com.digimart", "com.ecommerce.com.digimart.dbms", "com.ecommerce.com.digimart.dbms.services.mock"})
@SpringBootApplication(scanBasePackages = "com.ecommerce.com.digimart")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
