package com.hamze.reactivelabblocking.repository.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.hamze.reactivelabblocking.repository.api"})
@EntityScan(basePackages = "com.hamze.reactivelabblocking.domain.entity")
public class RepositoryConfiguration {
}
