package com.microservices.training.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.microservices.training.domain.repository")
@EntityScan(basePackages = "com.microservices.training.domain.entity")
@EnableTransactionManagement
public class DomainConfig {
}
