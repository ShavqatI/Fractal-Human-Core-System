package com.fractal.domain.integration.mapping.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrganizationMappingRepository extends JpaRepository<OrganizationMapping,Long> {

}
