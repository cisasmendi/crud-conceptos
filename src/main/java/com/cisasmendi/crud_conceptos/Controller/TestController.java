package com.cisasmendi.crud_conceptos.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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