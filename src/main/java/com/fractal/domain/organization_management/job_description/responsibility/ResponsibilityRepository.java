package com.fractal.domain.organization_management.job_description.responsibility;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsibilityRepository extends JpaRepository<Responsibility,Long> {
}
