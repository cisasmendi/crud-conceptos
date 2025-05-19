package com.cisasmendi.crud_conceptos.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static com.cisasmendi.crud_conceptos.config.RabbitMQConfig.QUEUE_NAME;

@Service
public class RabbitMQReceiver {

    @RabbitListener(queues = QUEUE_NAME)
    public void recibirMensaje(String mensaje) {
        System.out.println("Mensaje recibido: " + mensaje);
    }
}
