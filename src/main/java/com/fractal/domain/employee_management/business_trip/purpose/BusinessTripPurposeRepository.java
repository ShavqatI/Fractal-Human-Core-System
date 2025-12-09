package com.fractal.domain.employee_management.business_trip.purpose;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface BusinessTripPurposeRepository extends JpaRepository<BusinessTripPurpose, Long> {
    Optional<BusinessTripPurpose> findByCode(String code);

}
