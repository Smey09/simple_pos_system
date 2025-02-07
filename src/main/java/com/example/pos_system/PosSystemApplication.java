package com.example.pos_system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "E-Commerce APIs",
				version = "V1.0.0",
				description = "E-Commerce Management System",
				contact = @Contact(
						url = "https://my-portfolio-gold-mu-11.vercel.app",
						name = "Smey.dev.kh",
						email = "reomreaksmey7@gmail.com"
				))
)
public class PosSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosSystemApplication.class, args);
	}

}
