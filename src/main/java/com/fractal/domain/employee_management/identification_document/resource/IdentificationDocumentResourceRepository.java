package com.fractal.domain.employee_management.identification_document.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdentificationDocumentResourceRepository extends JpaRepository<IdentificationDocumentResource,Long> {

    List<IdentificationDocumentResource> findAllByIdentificationDocumentId(Long identificationDocumentId);
    Optional<IdentificationDocumentResource> findByIdentificationDocumentIdAndId(Long identificationDocumentId, Long id);
}
