package com.fractal.domain.integration.mapping.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DocumentTemplateManagerRepository extends JpaRepository<DepartmentMapping,Long> {
    Optional<DepartmentMapping> findById(Long id);
    Optional<DepartmentMapping> findByCode(String code);
    List<DepartmentMapping> findAll();
}
