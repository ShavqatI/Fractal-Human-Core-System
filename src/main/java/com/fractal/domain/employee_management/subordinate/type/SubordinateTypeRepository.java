package com.fractal.domain.employee_management.subordinate.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface SubordinateTypeRepository extends JpaRepository<SubordinateType,Long> {
    Optional<SubordinateType> findById(Long id);
    Optional<SubordinateType> findByCode(String code);
    List<SubordinateType> findAll();
}
