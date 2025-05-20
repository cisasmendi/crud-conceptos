package com.cisasmendi.crud_conceptos.service;



import com.cisasmendi.crud_conceptos.dto.MensajeReceiveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, MensajeReceiveDTO> redisTemplate;

    public void guardarResultado(MensajeReceiveDTO resultado) {
        redisTemplate.opsForValue().set(resultado.getId(), resultado);
    }

    public MensajeReceiveDTO obtenerResultado(String id) {
        return redisTemplate.opsForValue().get(id);
    }
}
