package com.cisasmendi.crud_conceptos.repository;

import com.cisasmendi.crud_conceptos.model.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConceptoRepository extends JpaRepository<Concepto, Long> {

    List<Concepto> findByTipo(String tipo);

    List<Concepto> findByCodigoContainingOrConceptoContaining(String codigo, String concepto);

    Optional<Concepto> findByCodigo(String codigo);
}
