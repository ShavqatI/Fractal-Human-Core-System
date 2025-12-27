package com.fractal.domain.organization_management.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Organization save(Organization organization);

    List<Organization> findAll();

    List<Organization> findAllByOrganizationUnitCodeIn(List<String> codes);
    @Query("""
    select o from Organization o 
    where o.organizationUnit.code = 'HEADOFFICE'
    and o.status.code = 'ACTIVE'
    """)
    Optional<Organization> findHeadOffice();

    Optional<Organization> findByCode(String code);

    Optional<Organization> findById(Long id);

    Optional<Organization> findFirstByOrderByIdDesc();
}
