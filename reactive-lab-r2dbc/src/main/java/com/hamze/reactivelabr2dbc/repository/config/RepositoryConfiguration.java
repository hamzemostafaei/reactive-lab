package com.hamze.reactivelabr2dbc.repository.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableR2dbcRepositories(basePackages = {"com.hamze.reactivelabr2dbc.repository"})
public class RepositoryConfiguration {
}
