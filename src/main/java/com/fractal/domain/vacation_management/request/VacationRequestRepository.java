package com.fractal.domain.vacation_management.request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VacationRequestRepository extends JpaRepository<VacationRequest, Long> {

    List<VacationRequest> findAllByEmployeeId(Long employeeId);

}
