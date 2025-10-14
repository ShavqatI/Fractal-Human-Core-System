package com.fractal.domain.employment.kind;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface EmploymentKindRepository extends JpaRepository<EmploymentKind,Long> {
    Optional<EmploymentKind> findByCode(String code);
}
