package com.cisasmendi.crud_conceptos;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.data.redis.core.RedisTemplate;



@SpringBootApplication(scanBasePackages = "com.cisasmendi.crud_conceptos")
@EntityScan(basePackages = "com.cisasmendi.crud_conceptos.model")
@EnableRabbit
public class CrudConceptosApplication {
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing() // esta línea evita el crash si el archivo no existe
				.load();

		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
		SpringApplication.run(CrudConceptosApplication.class, args);
	}

	@org.springframework.context.annotation.Bean
	public org.springframework.boot.CommandLineRunner runOnStartup() {
		return args -> {
			redisTemplate.opsForValue().set("test", "hola");
			// si no se puede conectar a redis, termina el programa y lanza un log de error
			if (redisTemplate.getConnectionFactory() == null) {
				System.err.println("No se puede conectar a Redis");
				System.exit(1);
			}
			System.out.println("Redis dice: " + redisTemplate.opsForValue().get("test"));
		};
	}

}
