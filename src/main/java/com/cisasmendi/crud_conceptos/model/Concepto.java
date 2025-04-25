package com.cisasmendi.crud_conceptos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "conceptos", indexes = {
    @Index(name = "idx_codigo", columnList = "codigo")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Concepto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String codigo;

    @NotNull
    private String concepto;

    @DecimalMin(value = "0.00", inclusive = true)
    private Double porcentaje;

    @DecimalMin(value = "0.00", inclusive = true)
    private Double importe;

    @NotNull
    private String procedimientoLiquidacion;

    @NotNull
    private String articuloEstatuto;

    @NotNull
    private String ordenanza;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @NotNull
    private String formula;

    private String variables;
    
    private String descripcion;

    public enum Tipo {
        REMUNERATIVO,
        NO_REMUNERATIVO
    }

}
