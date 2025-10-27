package com.fractal.domain.dictionary.docuemnt_template_manager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DocumentTemplateManagerRepository extends JpaRepository<DocumentTemplateManager,Long> {
    Optional<DocumentTemplateManager> findById(Long id);
    Optional<DocumentTemplateManager> findByCode(String code);
    List<DocumentTemplateManager> findAll();
}
