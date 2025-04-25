package com.cisasmendi.crud_conceptos.dto;



import com.cisasmendi.crud_conceptos.model.Concepto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConceptoResponseDTO {

    private Long id;
    private String codigo;
    private String concepto;
    private Double porcentaje;
    private Double importe;
    private String procedimientoLiquidacion;
    private String articuloEstatuto;
    private String ordenanza;
    private String formula;
    private String variables;
    private String descripcion;
    private String tipo;

    public ConceptoResponseDTO(Concepto concepto) {
        this.id = concepto.getId();
        this.codigo = concepto.getCodigo();
        this.concepto = concepto.getConcepto();
        this.porcentaje = concepto.getPorcentaje();
        this.importe = concepto.getImporte();
        this.procedimientoLiquidacion = concepto.getProcedimientoLiquidacion();
        this.articuloEstatuto = concepto.getArticuloEstatuto();
        this.ordenanza = concepto.getOrdenanza();
        this.formula = concepto.getFormula();
        this.variables = concepto.getVariables();
        this.descripcion = concepto.getDescripcion();
        this.tipo = concepto.getTipo().toString();
    }
}
