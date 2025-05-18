package com.fractal.domain.organization_management.organization.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrganizationAddressRepository extends JpaRepository<OrganizationAddress, Long> {
}
