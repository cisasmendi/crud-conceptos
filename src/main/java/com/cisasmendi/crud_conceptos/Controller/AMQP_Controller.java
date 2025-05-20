package com.cisasmendi.crud_conceptos.controller;

import com.cisasmendi.crud_conceptos.dto.MensajeReceiveDTO;
import com.cisasmendi.crud_conceptos.dto.MensajeSendDTO;
import com.cisasmendi.crud_conceptos.service.RabbitMQSender;
import com.cisasmendi.crud_conceptos.service.RedisService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/amqp")
public class AMQP_Controller {

    private final RabbitMQSender sender;
    private final RedisService redisService;

    public AMQP_Controller(RabbitMQSender sender, RedisService redisService) {
        this.sender = sender;
        this.redisService = redisService;
    }

    @PostMapping("/")
    public ResponseEntity<String> enviarMensaje(@RequestBody MensajeSendDTO mensaje) {
        if (mensaje.getId() == null || mensaje.getId().isEmpty()) {
            mensaje.setId(UUID.randomUUID().toString());
        }
        sender.enviarMensaje(mensaje);
        // RETORNA EL ID DEL MENSAJE {ID:mensaje.getId()} O EL ID QUE SE LE HAYA
        // ASIGNADO
        return ResponseEntity.ok("{\"ID\":\"" + mensaje.getId() + "\"}");

    }

    @GetMapping("/")
    public ResponseEntity<?> recibirMensaje(@RequestParam String id) {
        MensajeReceiveDTO resultado = redisService.obtenerResultado(id);

        if (resultado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(resultado);
    }

}
