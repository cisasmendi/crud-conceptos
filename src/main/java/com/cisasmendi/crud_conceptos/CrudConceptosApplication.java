package com.cisasmendi.crud_conceptos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@SpringBootApplication(scanBasePackages = "com.cisasmendi.crud_conceptos")
@EntityScan(basePackages = "com.cisasmendi.crud_conceptos.model") 
@EnableRabbit
public class CrudConceptosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudConceptosApplication.class, args);
	}

}
