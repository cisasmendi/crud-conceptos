package com.cisasmendi.crud_conceptos.service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cisasmendi.crud_conceptos.dto.ConceptoRequestDTO;
import com.cisasmendi.crud_conceptos.dto.ConceptoResponseDTO;

public interface ConceptoService {

    ConceptoResponseDTO crearConcepto(ConceptoRequestDTO conceptoRequestDTO);

    ConceptoResponseDTO obtenerConcepto(Long id);

    Page<ConceptoResponseDTO> obtenerTodosConceptos(Pageable pageable);

    List<ConceptoResponseDTO> obtenerPorTipo(String tipo);

    List<ConceptoResponseDTO> buscarConceptos(String codigo, String concepto);

    ConceptoResponseDTO actualizarConcepto(Long id, ConceptoRequestDTO conceptoRequestDTO);

    void eliminarConcepto(Long id);
}
