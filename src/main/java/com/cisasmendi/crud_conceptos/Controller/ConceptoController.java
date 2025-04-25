package com.cisasmendi.crud_conceptos.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cisasmendi.crud_conceptos.dto.ConceptoRequestDTO;
import com.cisasmendi.crud_conceptos.dto.ConceptoResponseDTO;
import com.cisasmendi.crud_conceptos.service.ConceptoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/conceptos")
public class ConceptoController {

    @Autowired
    private ConceptoService conceptoService;

    @PostMapping
    public ResponseEntity<ConceptoResponseDTO> crearConcepto(@Valid @RequestBody ConceptoRequestDTO conceptoRequestDTO) {
        ConceptoResponseDTO response = conceptoService.crearConcepto(conceptoRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConceptoResponseDTO> obtenerConcepto(@PathVariable Long id) {
        ConceptoResponseDTO response = conceptoService.obtenerConcepto(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<ConceptoResponseDTO>> obtenerTodosConceptos(Pageable pageable) {
        Page<ConceptoResponseDTO> conceptos = conceptoService.obtenerTodosConceptos(pageable);
        return ResponseEntity.ok(conceptos);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ConceptoResponseDTO>> obtenerPorTipo(@PathVariable String tipo) {
        List<ConceptoResponseDTO> conceptos = conceptoService.obtenerPorTipo(tipo);
        return ResponseEntity.ok(conceptos);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ConceptoResponseDTO>> buscarConceptos(@RequestParam String codigo, @RequestParam String concepto) {
        List<ConceptoResponseDTO> conceptos = conceptoService.buscarConceptos(codigo, concepto);
        return ResponseEntity.ok(conceptos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConceptoResponseDTO> actualizarConcepto(@PathVariable Long id, @Valid @RequestBody ConceptoRequestDTO conceptoRequestDTO) {
        ConceptoResponseDTO response = conceptoService.actualizarConcepto(id, conceptoRequestDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConcepto(@PathVariable Long id) {
        conceptoService.eliminarConcepto(id);
        return ResponseEntity.noContent().build();
    }
}
