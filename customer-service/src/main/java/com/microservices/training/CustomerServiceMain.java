package com.microservices.training;

import com.microservices.training.domain.entity.Customer;
import com.microservices.training.domain.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceMain {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceMain.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer(15, "John Doe"));
		};
	}
}
