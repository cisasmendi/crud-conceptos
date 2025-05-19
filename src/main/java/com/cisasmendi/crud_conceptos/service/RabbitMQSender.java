package com.cisasmendi.crud_conceptos.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisasmendi.crud_conceptos.dto.MensajeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public void enviarMensaje(MensajeDTO mensaje) {
        try {
            String json = objectMapper.writeValueAsString(mensaje);
            rabbitTemplate.convertAndSend("expresiones", json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
