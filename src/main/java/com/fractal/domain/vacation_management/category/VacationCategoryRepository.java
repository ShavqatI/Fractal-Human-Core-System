package com.fractal.domain.vacation_management.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface VacationCategoryRepository extends JpaRepository<VacationCategory,Long> {
    Optional<VacationCategory> findByCode(String code);

}
