package com.cisasmendi.crud_conceptos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(scanBasePackages = "com.cisasmendi.crud_conceptos")
@EntityScan(basePackages = "com.cisasmendi.crud_conceptos.model")
@EnableRabbit
public class CrudConceptosApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
                      .ignoreIfMissing() // esta línea evita el crash si el archivo no existe
                      .load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(CrudConceptosApplication.class, args);
	}

}
