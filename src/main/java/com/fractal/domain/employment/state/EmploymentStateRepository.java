package com.fractal.domain.employment.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface EmploymentStateRepository extends JpaRepository<EmploymentState, Long> {

    List<EmploymentState> findAllByEmploymentId(Long employmentId);

}
