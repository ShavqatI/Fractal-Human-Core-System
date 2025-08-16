package com.fractal.domain.employee_management.identification_document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmployeeIdentificationDocumentRepository extends JpaRepository<EmployeeIdentificationDocument, Long> {
    List<EmployeeIdentificationDocument> findAllByEmployeeId(Long employeeId);
}
