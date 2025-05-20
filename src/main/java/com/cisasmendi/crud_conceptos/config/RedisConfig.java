package com.cisasmendi.crud_conceptos.config;

import com.cisasmendi.crud_conceptos.dto.MensajeReceiveDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.*;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, MensajeReceiveDTO> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, MensajeReceiveDTO> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // Serializadores para clave y valor
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        return template;
    }
}
