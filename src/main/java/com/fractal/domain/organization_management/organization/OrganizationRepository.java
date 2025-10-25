package com.fractal.domain.organization_management.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OrganizationRepository extends JpaRepository<Organization,Long> {

    Organization save(Organization organization);
    List<Organization> findAll();
    List<Organization> findAllByOrganizationUnitCodeIn(List<String> codes);
    Optional<Organization> findByCode(String code);
    Optional<Organization> findById(Long id);

    Optional<Organization> findFirstByOrderByIdDesc();
}
