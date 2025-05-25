package com.fractal.domain.employee_management.education.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EducationTypeRepository extends JpaRepository<EducationType,Long> {
    Optional<EducationType> findById(Long id);
    Optional<EducationType> findByCode(String code);
    List<EducationType> findAll();
}
