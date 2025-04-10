package com.fractal.domain.organization_management.organization_unit;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit,Long> {

    OrganizationUnit save(OrganizationUnit organizationUnit);
    List<OrganizationUnit> findAll();
    Optional<OrganizationUnit> findByCode(String code);
    Optional<OrganizationUnit> findById(Long id);
}
