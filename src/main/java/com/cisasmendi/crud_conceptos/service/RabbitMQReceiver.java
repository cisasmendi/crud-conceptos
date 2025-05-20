package com.cisasmendi.crud_conceptos.service;

import com.cisasmendi.crud_conceptos.dto.MensajeReceiveDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.cisasmendi.crud_conceptos.config.RabbitMQConfig.QUEUE_NAME;

@Service
public class RabbitMQReceiver {

    @Autowired
    private RedisService redisService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "resultado")
    public void recibirMensaje(String mensajeJson) {
        try {
            MensajeReceiveDTO resultado = objectMapper.readValue(mensajeJson, MensajeReceiveDTO.class);
            System.out.println("Mensaje recibido: " + resultado.toString());

            // Guardar en Redis
            redisService.guardarResultado(resultado);

        } catch (Exception e) {
            System.err.println("Error al procesar el mensaje: " + e.getMessage());
        }
    }
}
