package com.fractal.domain.employment.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface EmploymentTypeRepository extends JpaRepository<EmploymentType,Long> {
    Optional<EmploymentType> findById(Long id);
    Optional<EmploymentType> findByCode(String code);
    List<EmploymentType> findAll();
}
