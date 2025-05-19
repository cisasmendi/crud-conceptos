package com.cisasmendi.crud_conceptos.dto;

import java.util.Map;

public class MensajeDTO {
    private String id;
    private String expresion;
    private Map<String, Object> variables;

    public MensajeDTO() {
        // Constructor vacío requerido por Spring
    }

    public MensajeDTO(String id, String expresion, Map<String, Object> variables) {
        this.id = id;
        this.expresion = expresion;
        this.variables = variables;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
