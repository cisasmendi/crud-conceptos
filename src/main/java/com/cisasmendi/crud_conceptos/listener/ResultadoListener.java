package com.cisasmendi.crud_conceptos.listener;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResultadoListener {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "resultado")
    public void recibirMensaje(String mensajeJson) {
        try {
            Map<String, Object> resultado = objectMapper.readValue(mensajeJson, Map.class);
            System.out.println("📥 Resultado recibido desde RabbitMQ:");
            resultado.forEach((k, v) -> System.out.println(k + ": " + v));
        } catch (Exception e) {
            System.err.println("❌ Error al procesar mensaje: " + e.getMessage());
        }
    }
}
