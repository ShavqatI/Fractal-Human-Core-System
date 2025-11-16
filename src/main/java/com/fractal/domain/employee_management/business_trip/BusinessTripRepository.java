package com.fractal.domain.employee_management.business_trip;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface BusinessTripRepository extends JpaRepository<BusinessTrip, Long> {

    List<BusinessTrip> findAllByEmployeeId(Long employeeId);

}
