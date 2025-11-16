package com.fractal.domain.organization_management.organization.contact;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationContactRepository extends JpaRepository<OrganizationContact, Long> {
    List<OrganizationContact> findAllByOrganizationId(Long organizationId);

    Optional<OrganizationContact> findByOrganizationIdAndId(Long organizationId, Long id);
}
