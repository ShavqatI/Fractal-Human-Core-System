package com.fractal.domain.employee_management.business_trip.resource;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessTripResourceRepository extends JpaRepository<BusinessTripResource, Long> {

    List<BusinessTripResource> findAllByBusinessTripId(Long employeeId);

    Optional<BusinessTripResource> findByBusinessTripIdAndId(Long employeeId, Long id);

}
