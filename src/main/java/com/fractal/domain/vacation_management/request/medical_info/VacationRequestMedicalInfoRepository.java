package com.fractal.domain.vacation_management.request.medical_info;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacationRequestMedicalInfoRepository extends JpaRepository<VacationRequestMedicalInfo,Long> {

    List<VacationRequestMedicalInfo> findAllByVacationRequestId(Long vacationRequestId);
    Optional<VacationRequestMedicalInfo> findByVacationRequestIdAndId(Long vacationRequestId, Long id);
}
