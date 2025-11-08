package com.fractal.domain.integration.mapping.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DocumentTemplateManagerRepository extends JpaRepository<EmployeeMapping,Long> {
    Optional<EmployeeMapping> findById(Long id);
    Optional<EmployeeMapping> findByCode(String code);
    List<EmployeeMapping> findAll();
}
