package com.fractal.domain.employee_management.education.degree_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface DegreeTypeRepository extends JpaRepository<DegreeType,Long> {
    Optional<DegreeType> findById(Long id);
    Optional<DegreeType> findByCode(String code);
    List<DegreeType> findAll();
}
