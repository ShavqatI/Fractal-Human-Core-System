package com.fractal.domain.organization_management.organization_unit;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit,Long> {

    OrganizationUnit save(OrganizationUnit organizationUnit);
}
