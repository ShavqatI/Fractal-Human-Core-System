package com.fractal.domain.employee_management.identification_document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface IdentificationDocumentRepository extends JpaRepository<IdentificationDocument, Long> {

}
