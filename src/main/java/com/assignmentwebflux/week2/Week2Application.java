package com.assignmentwebflux.week2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Week2Application {

	public static void main(String[] args) {
		SpringApplication.run(Week2Application.class, args);
//		ConfigurableApplicationContext context = SpringApplication.run(Week2Application.class, args);
//		HelloClient helloClient = context.getBean(HelloClient.class);

	}

}
