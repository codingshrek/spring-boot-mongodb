package com.sb.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sb.mongo")
public class SpringBootMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoApplication.class, args);
	}

}
