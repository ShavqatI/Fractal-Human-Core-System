package com.fractal.domain.vacation_management.request.education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface VacationRequestEducationRepository extends JpaRepository<VacationRequestEducation, Long> {
    List<VacationRequestEducation> findAllByVacationRequestId(Long vacationRequestId);

    Optional<VacationRequestEducation> findByVacationRequestIdAndId(Long vacationRequestId, Long id);
}
