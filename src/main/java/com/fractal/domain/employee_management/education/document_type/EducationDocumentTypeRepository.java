package com.fractal.domain.employee_management.education.document_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EducationDocumentTypeRepository extends JpaRepository<EducationDocumentType,Long> {
    Optional<EducationDocumentType> findById(Long id);
    Optional<EducationDocumentType> findByCode(String code);
    List<EducationDocumentType> findAll();
}
