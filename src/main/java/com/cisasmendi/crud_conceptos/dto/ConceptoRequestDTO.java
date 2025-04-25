package com.cisasmendi.crud_conceptos.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ConceptoRequestDTO {

    @NotBlank
    private String codigo;

    @NotBlank
    private String concepto;

    @PositiveOrZero
    private Double porcentaje;

    @PositiveOrZero
    private Double importe;

    @NotBlank
    private String procedimientoLiquidacion;

    @NotBlank
    private String articuloEstatuto;

    @NotBlank
    private String ordenanza;

    @NotBlank
    private String formula;

    private String variables;

    private String descripcion;

    @NotNull
    private String tipo;
}
