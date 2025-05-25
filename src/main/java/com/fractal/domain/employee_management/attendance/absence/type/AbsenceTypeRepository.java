package com.fractal.domain.employee_management.attendance.absence.type;

import com.fractal.domain.employee_management.education.type.EducationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface AbsenceTypeRepository extends JpaRepository<AbsenceType,Long> {
    Optional<AbsenceType> findById(Long id);
    Optional<AbsenceType> findByCode(String code);
    List<AbsenceType> findAll();
}
