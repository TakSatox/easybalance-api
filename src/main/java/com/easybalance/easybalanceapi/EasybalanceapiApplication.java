package com.easybalance.easybalanceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class EasybalanceapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasybalanceapiApplication.class, args);
	}

}
