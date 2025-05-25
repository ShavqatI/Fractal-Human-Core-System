package com.fractal.domain.employee_management.identification_document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Long> {

    List<IdentificationDocument> findAll();
    Optional<IdentificationDocument> findById(Long id);
}
