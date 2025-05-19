package com.cisasmendi.crud_conceptos.controller;

import com.cisasmendi.crud_conceptos.dto.MensajeDTO;
import com.cisasmendi.crud_conceptos.service.RabbitMQSender;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
@RestController
@RequestMapping("/api/amqp")
public class AMQP_Controller {

    private final RabbitMQSender sender;

    public AMQP_Controller(RabbitMQSender sender) {
        this.sender = sender;
    }

    @GetMapping("")
    public String holaMundo() {
        return "test amqp";
    }

    @PostMapping("/enviar")
    public ResponseEntity<String> enviarMensaje(@RequestBody MensajeDTO mensaje) {
        if (mensaje.getId() == null || mensaje.getId().isEmpty()) {
            mensaje.setId(UUID.randomUUID().toString());
        }
        sender.enviarMensaje(mensaje);
        return ResponseEntity.ok("Mensaje enviado a la cola 'expresiones'");
    }

}
