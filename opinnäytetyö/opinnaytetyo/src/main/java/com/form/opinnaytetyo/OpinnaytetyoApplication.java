package com.form.opinnaytetyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.*")
public class OpinnaytetyoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpinnaytetyoApplication.class, args);
	}

}
