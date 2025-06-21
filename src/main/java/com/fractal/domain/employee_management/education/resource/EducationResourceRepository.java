package com.fractal.domain.employee_management.education.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EducationResourceRepository extends JpaRepository<EducationResource,Long> {
    List<EducationResource> findAllByEducationId(Long educationId);
    Optional<EducationResource> findByEducationIdAndId(Long educationId, Long id);
}
