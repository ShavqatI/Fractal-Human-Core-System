package com.fractal.domain.employee_management.employment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory,Long> {


}
