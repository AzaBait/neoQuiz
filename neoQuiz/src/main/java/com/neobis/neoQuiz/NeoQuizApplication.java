package com.neobis.neoQuiz;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.neobis.neoQuiz")
@OpenAPIDefinition(servers = {
		@Server(url = "/", description = "Default Server URL")})
public class NeoQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeoQuizApplication.class, args);
	}

}
