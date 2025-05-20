package com.cisasmendi.crud_conceptos.dto;

import java.util.Map;

public class MensajeReceiveDTO {
    private String id;
    private String expresion;
    private Map<String, Object> variables;
    private Object resultado;

    public MensajeReceiveDTO() {
    }

    public MensajeReceiveDTO(String id, String expresion, Map<String, Object> variables, Object resultado) {
        this.id = id;
        this.expresion = expresion;
        this.variables = variables;
        this.resultado = resultado;
    }

    public String getId() {
        return id;
    }

    public String getExpresion() {
        return expresion;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public Object getResultado() {
        return resultado;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }

    public String toString() {
        return "MensajeReceiveDTO{" +
                "id='" + id + '\'' +
                ", expresion='" + expresion + '\'' +
                ", variables=" + variables +
                ", resultado=" + resultado +
                '}';
    }
}
