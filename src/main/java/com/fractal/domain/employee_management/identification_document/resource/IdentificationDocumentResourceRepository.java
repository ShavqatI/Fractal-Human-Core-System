package com.fractal.domain.employee_management.identification_document.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationDocumentResourceRepository extends JpaRepository<IdentificationDocumentResource,Long> {

}
