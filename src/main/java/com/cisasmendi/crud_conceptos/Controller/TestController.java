package com.cisasmendi.crud_conceptos.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    /**
     * Endpoint para comprobar que la API REST está funcionando correctamente.
     * @return Mensaje de éxito.
     */

    @GetMapping("/")
    public String holaMundo() {
        return "API REST funcionando correctamente";
    }
}