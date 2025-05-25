package com.fractal.domain.employee_management.vacation.category;

import com.fractal.domain.employee_management.vacation.type.VacationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface VacationCategoryRepository extends JpaRepository<VacationCategory,Long> {

    Optional<VacationCategory> findById(Long id);
    Optional<VacationCategory> findByCode(String code);
    List<VacationCategory> findAll();
}
