package com.hamze.reactivelabblocking.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.hamze.*")
public class ReactiveLabBlockingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveLabBlockingApplication.class, args);
	}

}
