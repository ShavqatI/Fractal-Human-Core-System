package com.fractal.domain.employee_management.identification_document.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface IdentificationDocumentTypeRepository extends JpaRepository<IdentificationDocumentType,Long> {
    Optional<IdentificationDocumentType> findById(Long id);
    Optional<IdentificationDocumentType> findByCode(String code);
    List<IdentificationDocumentType> findAll();
}
