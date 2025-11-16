package com.fractal.domain.employee_management.relative.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface RelationTypeRepository extends JpaRepository<RelationType, Long> {
    Optional<RelationType> findById(Long id);

    Optional<RelationType> findByCode(String code);

    List<RelationType> findAll();
}
