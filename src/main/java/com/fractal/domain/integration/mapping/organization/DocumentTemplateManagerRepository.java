package com.fractal.domain.integration.mapping.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DocumentTemplateManagerRepository extends JpaRepository<OrganizationMapping,Long> {
    Optional<OrganizationMapping> findById(Long id);
    Optional<OrganizationMapping> findByCode(String code);
    List<OrganizationMapping> findAll();
}
