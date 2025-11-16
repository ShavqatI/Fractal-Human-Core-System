package com.fractal.domain.organization_management.organization.work_schedule;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationWorkScheduleRepository extends JpaRepository<OrganizationWorkSchedule, Long> {
    List<OrganizationWorkSchedule> findAllByOrganizationId(Long organizationId);

    Optional<OrganizationWorkSchedule> findByOrganizationIdAndId(Long organizationId, Long id);
}
