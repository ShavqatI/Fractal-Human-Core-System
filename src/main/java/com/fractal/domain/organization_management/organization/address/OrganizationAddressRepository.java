package com.fractal.domain.organization_management.organization.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OrganizationAddressRepository extends JpaRepository<OrganizationAddress, Long> {
    List<OrganizationAddress> findAllByOrganizationId(Long organizationId);

    Optional<OrganizationAddress> findByOrganizationIdAndId(Long organizationId, Long id);
}
