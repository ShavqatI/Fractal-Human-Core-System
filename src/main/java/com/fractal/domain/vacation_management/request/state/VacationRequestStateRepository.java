package com.fractal.domain.vacation_management.request.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VacationRequestStateRepository extends JpaRepository<VacationRequestState,Long> {

    List<VacationRequestState> findAllByVacationRequestId(Long vacationRequestId);

}
