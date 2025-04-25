package com.cisasmendi.crud_conceptos.service;

import com.cisasmendi.crud_conceptos.dto.ConceptoRequestDTO;
import com.cisasmendi.crud_conceptos.dto.ConceptoResponseDTO;
import com.cisasmendi.crud_conceptos.model.Concepto;
import com.cisasmendi.crud_conceptos.repository.ConceptoRepository;
import com.cisasmendi.crud_conceptos.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConceptoServiceImpl implements ConceptoService {

    @Autowired
    private ConceptoRepository conceptoRepository;

    @Override
    public ConceptoResponseDTO crearConcepto(ConceptoRequestDTO conceptoRequestDTO) {
        Concepto concepto = new Concepto();
        concepto.setCodigo(conceptoRequestDTO.getCodigo());
        concepto.setConcepto(conceptoRequestDTO.getConcepto());
        concepto.setPorcentaje(conceptoRequestDTO.getPorcentaje());
        concepto.setImporte(conceptoRequestDTO.getImporte());
        concepto.setProcedimientoLiquidacion(conceptoRequestDTO.getProcedimientoLiquidacion());
        concepto.setArticuloEstatuto(conceptoRequestDTO.getArticuloEstatuto());
        concepto.setOrdenanza(conceptoRequestDTO.getOrdenanza());
        concepto.setFormula(conceptoRequestDTO.getFormula());
        concepto.setVariables(conceptoRequestDTO.getVariables());
        concepto.setDescripcion(conceptoRequestDTO.getDescripcion());
        concepto.setTipo(Concepto.Tipo.valueOf(conceptoRequestDTO.getTipo()));

        Concepto savedConcepto = conceptoRepository.save(concepto);
        return new ConceptoResponseDTO(savedConcepto);
    }

    @Override
    public ConceptoResponseDTO obtenerConcepto(Long id) {
        Concepto concepto = conceptoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concepto no encontrado con id: " + id));
        return new ConceptoResponseDTO(concepto);
    }

    @Override
    public Page<ConceptoResponseDTO> obtenerTodosConceptos(Pageable pageable) {
        return conceptoRepository.findAll(pageable).map(ConceptoResponseDTO::new);
    }

    @Override
    public List<ConceptoResponseDTO> obtenerPorTipo(String tipo) {
        List<Concepto> conceptos = conceptoRepository.findByTipo(tipo);
        return conceptos.stream().map(ConceptoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<ConceptoResponseDTO> buscarConceptos(String codigo, String concepto) {
        List<Concepto> conceptos = conceptoRepository.findByCodigoContainingOrConceptoContaining(codigo, concepto);
        return conceptos.stream().map(ConceptoResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ConceptoResponseDTO actualizarConcepto(Long id, ConceptoRequestDTO conceptoRequestDTO) {
        Concepto concepto = conceptoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concepto no encontrado con id: " + id));
        concepto.setCodigo(conceptoRequestDTO.getCodigo());
        concepto.setConcepto(conceptoRequestDTO.getConcepto());
        concepto.setPorcentaje(conceptoRequestDTO.getPorcentaje());
        concepto.setImporte(conceptoRequestDTO.getImporte());
        concepto.setProcedimientoLiquidacion(conceptoRequestDTO.getProcedimientoLiquidacion());
        concepto.setArticuloEstatuto(conceptoRequestDTO.getArticuloEstatuto());
        concepto.setOrdenanza(conceptoRequestDTO.getOrdenanza());
        concepto.setFormula(conceptoRequestDTO.getFormula());
        concepto.setTipo(Concepto.Tipo.valueOf(conceptoRequestDTO.getTipo()));
        concepto.setVariables(conceptoRequestDTO.getVariables());
        concepto.setDescripcion(conceptoRequestDTO.getDescripcion());

        Concepto updatedConcepto = conceptoRepository.save(concepto);
        return new ConceptoResponseDTO(updatedConcepto);
    }

    @Override
    public void eliminarConcepto(Long id) {
        Concepto concepto = conceptoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Concepto no encontrado con id: " + id));
        conceptoRepository.delete(concepto);
    }
}
