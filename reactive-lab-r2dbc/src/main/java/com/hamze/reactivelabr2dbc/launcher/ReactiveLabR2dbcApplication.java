package com.hamze.reactivelabr2dbc.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories(basePackages = "com.hamze.reactivelabr2dbc.repository.*")
@ComponentScan(basePackages = "com.hamze.reactivelabr2dbc")
public class ReactiveLabR2dbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveLabR2dbcApplication.class, args);
    }
}
