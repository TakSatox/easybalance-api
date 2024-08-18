package com.easybalance.easybalanceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
	servers = {
		@Server(url = "/", description = "Default server URL")
	}
)
public class EasybalanceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasybalanceapiApplication.class, args);
	}

}
