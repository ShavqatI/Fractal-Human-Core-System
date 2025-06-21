package com.fractal.domain.employee_management.citizenship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
interface CitizenshipRepository extends JpaRepository<Citizenship,Long> {


    List<Citizenship> findAllByEmployeeId(Long employeeId);
    Optional<Citizenship> findByEmployeeIdAndId(Long employeeId,Long id);
}
