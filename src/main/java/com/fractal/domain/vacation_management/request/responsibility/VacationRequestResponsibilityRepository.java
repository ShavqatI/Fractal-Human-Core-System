package com.fractal.domain.vacation_management.request.responsibility;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationRequestResponsibilityRepository extends JpaRepository<VacationRequestResponsibility, Long> {

    List<VacationRequestResponsibility> findAllByVacationRequestId(Long vacationRequestId);

    Optional<VacationRequestResponsibility> findByVacationRequestIdAndId(Long vacationRequestId, Long id);
}
