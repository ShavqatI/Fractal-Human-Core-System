package com.fractal.domain.vacation_management.vacation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface VacationRepository extends JpaRepository<Vacation, Long> {

    List<Vacation> findAllByEmployeeId(Long employeeId);

}
